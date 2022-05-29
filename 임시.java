/*
 * @(#)StagePoolService $version 2016-03-07
 *
 * Copyright 2016 Line Plus Corp. All rights Reserved.
 * Line Plus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.linecorp.bubble.service.stagepool;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.JsonNode;
import com.linecorp.bubble.model.event.EventMaster;
import com.linecorp.bubble.model.event.EventType;
import com.linecorp.bubble.model.gamedata.stagepool.*;
import com.linecorp.bubble.repository.event.EventMasterRepository;
import com.linecorp.bubble.repository.stagepool.NormalStageRepository;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.linecorp.bubble.exception.ErrorTypeException;
import com.linecorp.bubble.exception.GeneralErrorType;
import com.linecorp.bubble.model.AdvantageType;
import com.linecorp.bubble.model.SelectBox;
import com.linecorp.bubble.model.gamedata.failBonus.FailBonusDetail;
import com.linecorp.bubble.model.stage.BubbleCategory;
import com.linecorp.bubble.model.stage.BubbleType;
import com.linecorp.bubble.model.stage.ConditionalGoalType;
import com.linecorp.bubble.model.stage.DecoBubbleType;
import com.linecorp.bubble.model.stage.DisturbBubbleDelegateType;
import com.linecorp.bubble.model.stage.StageConditionType;
import com.linecorp.bubble.model.stage.StageMap;
import com.linecorp.bubble.model.stage.StagePoolExtraOption;
import com.linecorp.bubble.model.stage.StageType;
import com.linecorp.bubble.model.stage.TopClearType;
import com.linecorp.bubble.model.stage.TreasureBubbleType;
import com.linecorp.bubble.model.stage.template.BubbleTemplate;
import com.linecorp.bubble.model.stage.template.MapTemplate;
import com.linecorp.bubble.model.stage.template.RowTemplate;
import com.linecorp.bubble.repository.FailBonusDetailRepository;
import com.linecorp.bubble.repository.gameData.stagepool.StagePoolBadFlowerRepository;
import com.linecorp.bubble.repository.gameData.stagepool.StagePoolBossRepository;
import com.linecorp.bubble.repository.gameData.stagepool.StagePoolBossSkillRepository;
import com.linecorp.bubble.repository.gameData.stagepool.StagePoolBubbleRepository;
import com.linecorp.bubble.repository.gameData.stagepool.StagePoolExtraOptionRepository;
import com.linecorp.bubble.repository.gameData.stagepool.StagePoolGoalRepository;
import com.linecorp.bubble.repository.stagepool.StagePoolIndexRepository;
import com.linecorp.bubble.repository.stagepool.StagePoolRepository;
import com.linecorp.bubble.service.AdminContentService;
import com.linecorp.bubble.service.BubbleService;
import com.linecorp.bubble.service.stage.StageMapService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hi-seongmin.kim@linecorp.com
 */
@Slf4j
@Service
public class StagePoolService {
    @Autowired
    private AdminContentService<StagePool> adminContentService;
    @Autowired
    private StagePoolRepository stagePoolRepository;
    @Autowired
    private StagePoolGoalRepository stagePoolGoalRepository;
    @Autowired
    private StagePoolBubbleRepository stagePoolBubbleRepository;
    @Autowired
    private StagePoolExtraOptionRepository stagePoolExtraOptionRepository;
    @Autowired
    private StagePoolIndexRepository stagePoolIndexRepository;
    @Autowired
    private FailBonusDetailRepository failBonusDetailRepository;
    @Autowired
    private BubbleService bubbleService;
    @Autowired
    @Qualifier("objectMapper")
    protected ObjectMapper objectMapper;
    @Autowired
    private StagePoolBossRepository stagePoolBossRepository;
    @Autowired
    private StagePoolBossSkillRepository stagePoolBossSkillRepository;
    @Autowired
    private StagePoolBadFlowerRepository stagePoolBadFlowerRepository;
    @Autowired
    private StageMapService stageMapService;
    @Autowired
    private EventMasterRepository eventMasterRepository;
    @Autowired
    private NormalStageRepository normalStageRepository;

    private static final StagePool EMPTY_STAGEPOOL = new StagePool();
    public static final int DEFAULT_REV = 0;

    private static final Map<AdvantageType, String> QUESTION_BUBBLE_MAP = ImmutableMap.<AdvantageType, String>builder()
            .put(AdvantageType.QUESTION_MAPPING_PROB_1, BubbleType.Q_QUESTION_1.getCode())
            .put(AdvantageType.QUESTION_MAPPING_PROB_2, BubbleType.Q_QUESTION_2.getCode())
            .put(AdvantageType.QUESTION_MAPPING_PROB_3, BubbleType.Q_QUESTION_3.getCode())
            .put(AdvantageType.QUESTION_MAPPING_PROB_4, BubbleType.Q_QUESTION_4.getCode())
            .put(AdvantageType.QUESTION_MAPPING_PROB_5, BubbleType.Q_QUESTION_5.getCode())
            .build();

    public StagePool getStagePool(int seqNo) {
        return getStagePoolWithRev(seqNo, DEFAULT_REV);
    }

    public void insertStagePool(StagePool content) {
        insertStagePool(content, DEFAULT_REV);
    }

    public void insertStagePool(StagePool content, int rev) {
        log.info("Inserted : {}", content);
        content.setRev(rev);
        stagePoolRepository.insertStagePool(content);
        saveStagePoolDetail(content, rev);
    }

    public void updateStagePool(StagePool content) {
        log.info("updated : {}", content);
        stagePoolBubbleRepository.deleteStagePoolBubble(content.getSeqNo(), DEFAULT_REV);
        stagePoolExtraOptionRepository.deleteStagePoolExtraOption(content.getSeqNo(), DEFAULT_REV);
        stagePoolGoalRepository.deleteStagePoolGoal(content.getSeqNo(), DEFAULT_REV);
        stagePoolBadFlowerRepository.deleteStagePoolBadFlower(content.getSeqNo());
        stagePoolBossRepository.deleteStagePoolBoss(content.getSeqNo());
        stagePoolBossSkillRepository.deleteStagePoolBossSkill(content.getSeqNo());
        stagePoolRepository.deleteStagePoolBubbleSetLink(content.getSeqNo());
        stagePoolRepository.updateStagePool(content.getSeqNo(), DEFAULT_REV, content);
        saveStagePoolDetail(content, DEFAULT_REV);
    }

    public boolean deleteStagePool(int seqNo) {
        stagePoolIndexRepository.insertStagePoolIndex(seqNo, StageMode.DELETE, seqNo);
        return true;
    }

    public List<Integer> deleteStagePoolBundle(List<Integer> selected) {
        int rev = 0;
        List usedStages = selected.stream().filter(stageNo -> {
            try {
                normalStageRepository.selectStage(stageNo, rev);
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            }
        }).collect(Collectors.toList());

        if (usedStages.size() == 0) {
            for (int seqNo : selected) {
                stagePoolIndexRepository.insertStagePoolIndex(seqNo, StageMode.DELETE, seqNo);
            }
        }
        return usedStages;
    }

    public boolean restoreStagePool(int seqNo) {
        stagePoolIndexRepository.deleteStagePoolIndex(seqNo);
        return true;
    }

    private void saveStagePoolDetail(StagePool content, int rev) {
        stagePoolGoalRepository.insertStagePoolGoal(content.getSeqNo(), rev, content.getStagePoolGoalList());
        if (content.getStagePoolBadFlowerList().isEmpty() == false) {
            stagePoolBadFlowerRepository.insertStagePoolBadFlower(content.getSeqNo(), content.getStagePoolBadFlowerList());
        }
        if (Objects.equals(content.getConstraintType(), "T") == false) {
            content.setTimeBubbleProb(0.0f);
        }
        saveStagePoolExtraOption(content, rev);
        saveStagePoolBubble(content, rev);
        saveStagePoolBoss(content);
    }

    private void saveStagePoolExtraOption(StagePool content, int rev) {
        if (content.getRandomBubbleSetNo() != 0) {
            stagePoolRepository.insertStagePoolBubbleSetLink(content.getSeqNo(), content.getRandomBubbleSetNo());
        }

        // Setting empty ArrayList to ignore random bubble values
        content.getStagePoolExtraOption().setRandomDisturbBubbleProbList(new ArrayList<>());
        content.getStagePoolExtraOption().setRandomBubbleTypeProbList(new ArrayList<>());

        if (content.getStageType() != StageType.DECO_COLLECT) {
            content.getStagePoolExtraOption().setDecoBubbleType(0);
        }
        stagePoolExtraOptionRepository.insertStagePoolExtraOption(content.getSeqNo(), rev, convertStageExtraOption(content.getStagePoolExtraOption()));
    }

    private void saveStagePoolBubble(StagePool content, int rev) {
        if (content.getStagePoolBubble().containsKey(BubbleCategory.RANDOM_MAPPING) == false) {
            List<StagePoolBubble> stagePoolBubbleList = Arrays.stream(BubbleType.values()).filter(input -> input.getGroup() == BubbleCategory.NORMAL)
                    .map(input -> new StagePoolBubble(content.getSeqNo(), rev, input.getCode(), 0, BubbleCategory.RANDOM_MAPPING.getCode()))
                    .collect(Collectors.toList());
            content.getStagePoolBubble().putAll(BubbleCategory.RANDOM_MAPPING, stagePoolBubbleList);
        }
        for (BubbleCategory category : content.getStagePoolBubble().keySet()) {
            if (category == BubbleCategory.TIME &&
                    Objects.equals(content.getConstraintType(), "T") == false) {
                continue;
            }
            if (content.getStageType() != StageType.NORMAL_COLLECT &&
                    content.getStageType() != StageType.DECO_COLLECT &&
                    content.getStageType() != StageType.FINAL_BOSS &&
                    category == BubbleCategory.LUCKY) {
                continue;
            }
            if (content.getStageType() != StageType.DECO_COLLECT &&
                    category == BubbleCategory.ADDITIONAL) {
                continue;
            }
            stagePoolBubbleRepository.insertStagePoolBubble(content.getSeqNo(), category.toString(), rev, content.getStagePoolBubble().get(category));
        }
    }

    private void saveStagePoolBoss(StagePool content) {
        if (content.getStageType() == StageType.FINAL_BOSS) {
            stagePoolBossRepository.insertStagePoolBoss(content.getSeqNo(), content.getStagePoolBossList());
            stagePoolBossSkillRepository.insertStagePoolBossSkillList(content.getSeqNo(), content.getStagePoolBossSkillList());
        }
        if (content.getStageType() == StageType.MIDDLE_BOSS) {
            stagePoolBossRepository.insertStagePoolBoss(content.getSeqNo(), content.getStagePoolBossList());
        }
    }

    @Caching(evict = {
            @CacheEvict(value = "stagepool", allEntries = true),
            @CacheEvict(value = "testStage", allEntries = true)
    })
    public void saveStagePool(StagePool stagePool) {
        adminContentService.manipulateContent(stagePool, this::insertStagePool, this::updateStagePool);
    }

    public List<StagePool> getAvailableStagePoolList() {
        return stagePoolRepository.selectAvailableStagePoolList(DEFAULT_REV);
    }

    public List<StagePool> getStagePoolList() {
        return stagePoolRepository.selectStagePoolList(DEFAULT_REV);
    }

    public List<StagePool> getAllStagePoolList() {
        return stagePoolRepository.selectAllStagePoolList(DEFAULT_REV);
    }

    public List<StagePool> getDeletedStagePoolList() {
        return stagePoolRepository.selectDeletedStagePoolList(DEFAULT_REV);
    }

    public ListMultimap<BubbleCategory, SelectBox> getBubbleTypeSelectBoxList() {
        return bubbleService.getBubbleTypeSelectBoxList(ImmutableList.of(BubbleCategory.LUCKY, BubbleCategory.TIME, BubbleCategory.DISTURB, BubbleCategory.RESCUE, BubbleCategory.QUESTION_MAPPING));
    }

    public List<SelectBox> getStageTypeSelectBoxList() {
        List<SelectBox> result = Lists.newArrayList();
        for (StageType stagePoolType : StageType.values()) {
            result.add(new SelectBox(stagePoolType.getCode(), stagePoolType.getDesc(), "StageType"));
        }
        return result;
    }

    public List<SelectBox> getEndTypeSelectBoxList() {
        List<SelectBox> result = Lists.newArrayList();
        for (StageConditionType type : StageConditionType.values()) {
            result.add(new SelectBox(type.getCode(), type.getText(), "EndType"));
        }
        return result;
    }

    public List<SelectBox> getStagePoolRevList(int seqNo) {
        List<SelectBox> selectBoxList = new ArrayList<>();
        selectBoxList.add(new SelectBox(String.valueOf(DEFAULT_REV), "TRUNK", "StagePoolRev"));
        selectBoxList.addAll(stagePoolRepository.selectStagePoolRevList(seqNo));
        return selectBoxList;
    }

    public StagePool getStagePoolWithRev(int seqNo, int rev) {
        try {
            StagePool stagePool = stagePoolRepository.selectStagePool(seqNo, rev);
            stagePool.setStagePoolBubble(getStagePoolBubbleMap(stagePoolBubbleRepository.selectStagePoolBubbleList(seqNo, rev)));
            stagePool.setStagePoolExtraOption(convertStageExtraOption(stagePoolExtraOptionRepository.selectStagePoolExtraOption(seqNo, rev)));
            stagePool.setStagePoolGoalList(stagePoolGoalRepository.selectStagePoolGoal(seqNo, rev));
            if (stagePool.getStageType() == StageType.FINAL_BOSS) {
                stagePool.setStagePoolBossList(stagePoolBossRepository.selectStagePoolBossWithSeqNo(seqNo));
                stagePool.setStagePoolBossSkillList(stagePoolBossSkillRepository.selectStagePoolBossSkillListWithSeqNo(seqNo));
            }
            if (stagePool.getStageType() == StageType.MIDDLE_BOSS) {
                stagePool.setStagePoolBossList(stagePoolBossRepository.selectStagePoolBossWithSeqNo(seqNo));
            }
            stagePool.setStagePoolBadFlowerList(stagePoolBadFlowerRepository.selectStagePoolBadFlower(seqNo));
            return stagePool;
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
            return EMPTY_STAGEPOOL;
        }
    }

    public StagePool getStagePoolWithRevAndBalance(int seqNo, int rev) {
        try {
            StagePool stagePool = getStagePoolWithRev(seqNo, rev);

            StagePoolIndex stagePoolIndex = stagePoolIndexRepository.selectStagePoolIndex(seqNo);
            if (stagePoolIndex != null && stagePoolIndex.getStageMode() == StageMode.NORMAL) {
                List<FailBonusDetail> failBonusDetailList = failBonusDetailRepository.selectFailBonusDetailList(stagePoolIndex.getStageNo());
                for (FailBonusDetail failBonusDetail : failBonusDetailList) {
                    switch (failBonusDetail.getBonusType()) {
                        case LUCKY_BUBBLE:
                            stagePool.setLuckyBubbleProb(failBonusDetail.getBasicValue());
                            break;
                        case BUBBLE_CROWD:
                            stagePool.setBubbleCrowd(failBonusDetail.getBasicValue());
                            break;
                        case TIME_BUBBLE:
                            stagePool.setTimeBubbleProb(failBonusDetail.getBasicValue());
                            break;
                        case DECO_BUBBLE:
                            List<StagePoolBubble> bubbleList = stagePool.getStagePoolBubble().get(BubbleCategory.ADDITIONAL);
                            Optional<StagePoolBubble> bubbleOptional = bubbleList.stream().filter(bubble -> bubble.getBubbleCode().equals(BubbleType.A_GLASS.getCode())).findFirst();    //S6
                            if (bubbleOptional.isPresent()) {
                                bubbleOptional.get().setAppearWeight(failBonusDetail.getBasicValue());
                            } else {
                                bubbleList.add(new StagePoolBubble(seqNo, rev, BubbleType.A_GLASS.getCode(), failBonusDetail.getBasicValue(), BubbleCategory.ADDITIONAL.getCode()));
                            }
                            break;
                        case QUESTION_MAPPING_PROB_1:
                        case QUESTION_MAPPING_PROB_2:
                        case QUESTION_MAPPING_PROB_3:
                        case QUESTION_MAPPING_PROB_4:
                        case QUESTION_MAPPING_PROB_5:
                            List<StagePoolBubble> questionBubbleList = stagePool.getStagePoolBubble().get(BubbleCategory.QUESTION_MAPPING);
                            Optional<StagePoolBubble> questionBubbleOptional = questionBubbleList.stream().filter(bubble -> bubble.getBubbleCode().equals(QUESTION_BUBBLE_MAP.get(failBonusDetail.getBonusType()))).findFirst();    //Q1 Q2 Q3 Q4 Q5
                            if (questionBubbleOptional.isPresent()) {
                                questionBubbleOptional.get().setAppearWeight(failBonusDetail.getBasicValue());
                            } else {
                                questionBubbleList.add(new StagePoolBubble(seqNo, rev, QUESTION_BUBBLE_MAP.get(failBonusDetail.getBonusType()), failBonusDetail.getBasicValue(), BubbleCategory.QUESTION_MAPPING.getCode()));
                            }
                            break;
                        //case BOSS_HP_DOWN:
                        //	break;
                        //case NEXT_BALL_SELECTION:
                        //	break;
                        default:
                            break;
                    }
                }
            }

            return stagePool;
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
            return EMPTY_STAGEPOOL;
        }
    }

    public StagePoolExtraOption convertStageExtraOption(String stagePoolExtraOptionJson) {
        if (Strings.isNullOrEmpty(stagePoolExtraOptionJson)) {
            return new StagePoolExtraOption();
        }
        try {
            StagePoolExtraOption stageExtraOption = objectMapper.readValue(stagePoolExtraOptionJson, StagePoolExtraOption.class);
            log.debug("Converted StagePoolExtraOption : {}", stageExtraOption);
            return stageExtraOption;
        } catch (IOException e) {
            log.warn(e.getMessage(), e);
            throw new ErrorTypeException(e, GeneralErrorType.SPECIFIED_JSON_DESERIALIZE);
        }
    }

    public String convertStageExtraOption(StagePoolExtraOption stagePoolExtraOption) {
        try {
            String stageExtraOptionJson = objectMapper.writeValueAsString(stagePoolExtraOption);
            log.debug("Converted StageExtraOptionJson : {}", stageExtraOptionJson);
            return stageExtraOptionJson;
        } catch (JsonProcessingException e) {
            log.warn(e.getMessage(), e);
            throw new ErrorTypeException(e, GeneralErrorType.SPECIFIED_JSON_SERIALIZE);
        }
    }

    public List<SelectBox> getGoalTypeSelectBoxList() {
        List<SelectBox> result = Arrays.stream(BubbleType.values()).filter(BubbleType::isGoalEnable).map(input -> new SelectBox(input.getCode(), input.getText(), "GoalType")).collect(Collectors.toList());
        result.addAll(Arrays.stream(ConditionalGoalType.values()).map(input -> new SelectBox(input.getCode(), input.getText(), "GoalType")).collect(Collectors.toList()));
        return result;
    }

    public List<SelectBox> getRescueFriendTypeSelectBoxList() {
        return Arrays.stream(TopClearType.values()).map(input -> new SelectBox(Integer.toString(input.getRescueFriendType()), input.getText(), "RescueFriendType")).collect(Collectors.toList());
    }

    public List<SelectBox> getDecoBubbleTypeSelectBoxList() {
        return Arrays.stream(DecoBubbleType.values()).map(input -> new SelectBox(Integer.toString(input.getValue()), input.getText(), "DecoBubbleType")).collect(Collectors.toList());
    }

    public List<SelectBox> getTreasureBubbleTypeSelectBoxList() {
        return Arrays.stream(TreasureBubbleType.values()).map(input -> new SelectBox(Integer.toString(input.getValue()), input.getText(), "TreasureBubbleType")).collect(Collectors.toList());
    }

    public void insertStagePoolIndex(int seqNo, StageMode stageMode, int stageNo) {
        stagePoolIndexRepository.insertStagePoolIndex(seqNo, stageMode, stageNo);
    }

    public void updateStagePoolIndex(int seqNo, StageMode stageMode, int stageNo) {
        stagePoolIndexRepository.updateStagePoolIndex(seqNo, stageMode, stageNo);
    }

    public void deleteStagePoolIndexByStageNo(StageMode stageMode, int stageNo) {
        stagePoolIndexRepository.deleteStagePoolIndexByStageNo(stageMode, stageNo);
    }

    public StagePoolIndex getStagePoolIndex(int seqNo) {
        return stagePoolIndexRepository.selectStagePoolIndex(seqNo);
    }

    public StagePoolIndex getStagePoolIndexByStageNo(StageMode stageMode, int stageNo) {
        return stagePoolIndexRepository.selectStagePoolIndexByStageNo(stageMode, stageNo);
    }

    public Map<StageType, List<SelectBox>> getEndTypeMap() {
        Map<StageType, List<SelectBox>> result = new HashMap<>();
        for (StageType type : StageType.values()) {
            switch (type) {
                case TREASURE: //B
                case TOP_CLEAR: //B
                case MIDDLE_BOSS: //B
                    result.put(type, Arrays.asList(new SelectBox(StageConditionType.BUBBLE.getCode(), StageConditionType.BUBBLE.getText(), "EndType")));
                    break;
                case FINAL_BOSS: //L
                    result.put(type, Arrays.asList(new SelectBox(StageConditionType.LINE_OVER.getCode(), StageConditionType.LINE_OVER.getText(), "EndType")));
                    break;
                case COIN_BONUS:
                case SCORE: //T
                    result.put(type, Arrays.asList(new SelectBox(StageConditionType.TIME.getCode(), StageConditionType.TIME.getText(), "EndType")));
                    break;
                case NORMAL_COLLECT: //BT
                case DECO_COLLECT: //BT
                default:
                    result.put(type, Stream.of(StageConditionType.BUBBLE, StageConditionType.TIME)
                            .map(input -> new SelectBox(input.getCode(), input.getText(), "EndType"))
                            .collect(Collectors.toList()));
                    break;
            }
        }
        return result;
    }

    public Map<StageType, List<SelectBox>> getGoalTypeMap() {
        Map<StageType, List<SelectBox>> result = new HashMap<>();
        for (StageType type : StageType.values()) {
            switch (type) {
                case NORMAL_COLLECT: //N R
                    List<SelectBox> normalCollectGoalList = Arrays.stream(BubbleType.values())
                            .filter(bubbleType ->
                                    bubbleType.getGroup() == BubbleCategory.NORMAL
                                            || bubbleType.getGroup() == BubbleCategory.RANDOM_MAPPING
                            )
                            .map(bubbleType -> new SelectBox(bubbleType.getCode(), bubbleType.getText(), "GoalType"))
                            .collect(Collectors.toList());
                    result.put(type, normalCollectGoalList);
                    break;
                case DECO_COLLECT: //S6
                    result.put(type, Arrays.asList(new SelectBox(BubbleType.A_GLASS.getCode(), BubbleType.A_GLASS.getText(), "GoalType")));
                    break;
                case TREASURE: //J
                    result.put(type, Arrays.asList(new SelectBox(ConditionalGoalType.TREASURE.getCode(), ConditionalGoalType.TREASURE.getText(), "GoalType")));
                    break;
                case TOP_CLEAR: //T
                    result.put(type, Arrays.asList(new SelectBox(ConditionalGoalType.TOP.getCode(), ConditionalGoalType.TOP.getText(), "GoalType")));
                    break;
                case MIDDLE_BOSS: //M
                    result.put(type, Arrays.asList(new SelectBox(ConditionalGoalType.MIDDLE_BOSS.getCode(), ConditionalGoalType.MIDDLE_BOSS.getText(), "GoalType")));
                    break;
                case FINAL_BOSS://F
                    result.put(type, Arrays.asList(new SelectBox(ConditionalGoalType.FINAL_BOSS.getCode(), ConditionalGoalType.FINAL_BOSS.getText(), "GoalType")));
                    break;
                case SCORE://S
                    result.put(type, Arrays.asList(new SelectBox(ConditionalGoalType.SCORE.getCode(), ConditionalGoalType.SCORE.getText(), "GoalType")));
                    break;
                case RESCUE_FRIEND:
                    result.put(type, Arrays.stream(BubbleType.values())
                            .filter(bubbleType -> bubbleType.getGroup() == BubbleCategory.RESCUE)
                            .map(bubbleType -> new SelectBox(bubbleType.getCode(), bubbleType.getText(), "GoalType"))
                            .collect(Collectors.toList()));
                    break;
                case COIN_BONUS:
                case ALPHABET:
                case SECRET:
                    result.put(type, Arrays.asList(new SelectBox(ConditionalGoalType.NOT_SPECIFIED.getCode(), ConditionalGoalType.NOT_SPECIFIED.getText(), "GoalType")));
                    break;
                case UNKNOWN:
                default:
                    result.put(type, ImmutableList.of());
                    break;
            }
        }
        return result;
    }

    public List<SelectBox> getRandomMappingBubbleSelectBoxList() {
        List<SelectBox> resultList = Arrays.stream(BubbleType.values())
                .filter(input -> input.getGroup() == BubbleCategory.NORMAL)
                .map(input -> new SelectBox(input.getType(), input.getText(), "RandomMappingBubble"))
                .collect(Collectors.toList());
        return resultList;
    }

    public ListMultimap<BubbleCategory, StagePoolBubble> getStagePoolBubbleMap(List<StagePoolBubble> stagePoolBubbleList) {
        Map<BubbleCategory, List<StagePoolBubble>> listMap = stagePoolBubbleList.stream().collect(Collectors.groupingBy(input -> BubbleCategory.valueOf(input.getCategory())));

        ArrayListMultimap listMultimap = ArrayListMultimap.create();
        listMap.entrySet().stream().forEach((entry) -> listMultimap.putAll(entry.getKey(), entry.getValue()));

        return listMultimap;
    }


    public List<String> getDisturbBubbleList(StagePool stagePool) {
        return getDisturbBubbleList(stagePool.getSeqNo(), stagePool.getMapJson());
    }

    public List<String> getDisturbBubbleList(int seqNo, String mapJson) {
        StageMap stageMap = stageMapService.convertStageMap(mapJson);
        Map<Integer, List<RowTemplate>> rowTemplateMap = stageMap.getMapTemplateSet().stream()
                .collect(Collectors.toMap(MapTemplate::getId, MapTemplate::getRowTemplateList));
        Map<Integer, BubbleTemplate> bubbleTemplateMap = stageMap.getBubbleTemplateSet().stream()
                .collect(Collectors.toMap(BubbleTemplate::getId, Function.identity()));
        Set<String> disturbBubbleSet = stageMap.getMapIdList().stream()
                .flatMap(mapId -> rowTemplateMap.getOrDefault(mapId, ImmutableList.of()).stream())
                .flatMap(rowTemplate -> rowTemplate.getBubbleIdList().stream())
                .flatMap(bubbleId -> Optional.ofNullable(bubbleTemplateMap.get(bubbleId))
                        .map(BubbleTemplate::getAllTypeList)
                        .orElseGet(ArrayList::new).stream())
                .map(DisturbBubbleDelegateType::resolveDelegateType)
                .collect(Collectors.groupingBy(Function.identity())).values().stream()
                .sorted((o1, o2) -> Integer.compare(o2.size(), o1.size()))
                .map(bubbleTypeList -> getBubbleCode(seqNo, bubbleTypeList))
                .filter(bubbleCode -> bubbleCode.isEmpty() == false)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return new ArrayList(disturbBubbleSet);
    }

    private String getBubbleCode(int seqNo, List<BubbleType> bubbleTypeList) {
        return bubbleTypeList.stream().findFirst().map(bubbleType -> {
            if (bubbleType.getGroup() == BubbleCategory.BAD_FLOWER) {
                return stagePoolBadFlowerRepository.selectStagePoolBadFlower(seqNo).stream()
                        .filter(stagePoolBadFlower -> Objects.equals(stagePoolBadFlower.getDelegateCode(), bubbleType))
                        .findFirst()
                        .map(StagePoolBadFlower::getFlowerCode)
                        .orElse("");
            } else {
                return bubbleType.getCode();
            }
        }).orElse("");
    }

    public boolean checkProgressStage(List<Integer> settingEventNoList) {
        if (settingEventNoList.size() > 0) {
            for (int i = 0; i < settingEventNoList.size(); i++) {
                Optional<EventMaster<EventType>> eventMaster = eventMasterRepository.selectEventMaster(settingEventNoList.get(i));
                if (eventMaster.isPresent()) {
                    DateTime now = new DateTime();
                    if (eventMaster.get().getEndDate().isAfter(now)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void processJsonNodeForStagePool(List<StagePoolChangedData> result , JsonNode targetData){
        if(targetData == null)
            return;
        if(targetData.isArray()){
            for(int i = 0 ; i < targetData.size() ; i++){
                JsonNode targetChildData = targetData.get(i);
                processJsonNodeForStagePool(result, targetChildData);
            }
        }else if(targetData.isObject()){
            Iterator<String> fieldNames = targetData.fieldNames(); //리스트로 바꾼다??
            while(fieldNames.hasNext()){
                String fieldName = fieldNames.next();
                JsonNode targetChildData = targetData.get(fieldName);
                processJsonNodeForStagePool(result, targetChildData);
            }
        }else{
            Iterator<String> processedFieldName = targetData.fieldNames();
            if(processedFieldName.hasNext()){
                String fieldName = processedFieldName.next();
                if(true) // 필요한 데이터인지 검증과정 //page6참조
                    result.add(new StagePoolChangedData(
                            "",
                            fieldName,
                            targetData.get(fieldName).toString()
                    ));
            }
        }
    }

    public void processJsonNodeForStagePoolModData(List<StagePoolChangedData> result , JsonNode modifiedData, JsonNode originalData){ //삭제할것
        if(modifiedData.isArray()){
            for(int i = 0; i < modifiedData.size() ; i++){
                JsonNode modifiedChildData = modifiedData.get(i);
                JsonNode originalChildData = originalData.get(i);
                processJsonNodeForStagePoolModData(result, modifiedChildData, originalChildData); //널이 발생하는 문제
            }
        }else if(modifiedData.isObject()){
            Iterator<String> fieldNames = modifiedData.fieldNames(); //리스트로 바꾼다??
            while(fieldNames.hasNext()){
                String fieldName = fieldNames.next();
                JsonNode modifiedChildData = modifiedData.get(fieldName);
                JsonNode originalChildData = originalData.get(fieldName);
                processJsonNodeForStagePoolModData(result, modifiedChildData, originalChildData);
            }
        }else{
            Iterator<String> processedFieldName = modifiedData.fieldNames();
            if(processedFieldName.hasNext()){
                String fieldName = processedFieldName.next();
                String modifiedValue = modifiedData.get(fieldName).toString();
                String originalValue = originalData.get(fieldName).toString();
                if(!modifiedValue.equals(originalValue)){
                    result.add(new StagePoolChangedData(
                            "",
                            fieldName,
                            modifiedValue,
                            originalValue
                    ));
                }
            }
        }
    }

    public StagePoolChangedDataList getChangedStagePoolData(JsonNode modifiedData) {
        StagePool originalData = getStagePoolWithRevAndBalance(modifiedData.get("seqNo").intValue(), modifiedData.get("rev").intValue());
        JsonNode originalJson = objectMapper.convertValue(originalData, JsonNode.class);
        JsonNode modifiedJson = objectMapper.convertValue(modifiedData, JsonNode.class);

        StagePoolChangedDataList changedDataResult = new StagePoolChangedDataList();

        Iterator<String> fieldNames = originalJson.fieldNames();

        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            JsonNode originalValue = originalJson.get(fieldName);
            JsonNode modifiedValue = modifiedJson.get(fieldName);
            List<StagePoolChangedData> modifiedDataList = new ArrayList<>();
            List<StagePoolChangedData> originalDataList = new ArrayList<>();

            processJsonNodeForStagePool(modifiedDataList, modifiedValue);
            processJsonNodeForStagePool(originalDataList, originalValue);

            if (originalValue == null && modifiedValue == null) {
                continue;
            } else if (originalValue == null) { //added
                List<StagePoolChangedData> addedDataList = new ArrayList<>();
                processJsonNodeForStagePool(addedDataList, modifiedValue);
                changedDataResult.getAddedRows().addAll(addedDataList);
            } else if (modifiedValue == null) { //deleted
                List<StagePoolChangedData> deletedDataList = new ArrayList<>();
                processJsonNodeForStagePool(deletedDataList, originalValue);
                changedDataResult.getDeletedRows().addAll(deletedDataList);
            } else {



                List<StagePoolChangedData> changedDataList = new ArrayList<>();
                processJsonNodeForStagePoolModData(changedDataList, modifiedValue, originalValue);
                changedDataResult.getChangedRows().addAll(changedDataList);
            }
        }

        return changedDataResult;

    }

}
