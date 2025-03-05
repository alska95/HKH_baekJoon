targetString = list(input())

targetNum = []
while targetString:
    Num = int(ord(targetString.pop(0)))

    if(Num >=83):
        if(Num == 83):
            targetNum.append(8)
        elif(Num >=87):
            targetNum.append(10)
        else:
            targetNum.append(9)
    else:
        targetNum.append((Num - 65) // 3 + 3)

print(sum(targetNum))