#include <iostream>

using namespace std;

void blackjack(int cardNum, int targetNum) {
	int a[100];
	int result = 0;

	for (int i = 0; i < cardNum; i++) {
		cin >> a[i];
	}

	for (int i = 0; i < cardNum; i++) {
		for (int j = 0; j < cardNum - 1; j++) {
			for (int k = 0; k < cardNum - 2; k++) {
				if (a[i] + a[j] + a[k] <= targetNum && a[i] + a[j] + a[k] > result)
					result = a[i] + a[j] + a[k];
			}
		}
	}
}
/*
N장의 카드를 입력받는다
타겟넘버 M을 입력받는다
N장에 해당하는 숫자를 입력받는다
N장의 카드들 중에 3장을 뽑아 M에 가장 가까운 수를 만든다.

N장을 정렬
경우의 수
아래부터 채워넣는다? 이건 불가능
위에서부터 채워넣는다
	이경우에 문제점
	제일 큰 수를 넣을 시 작은수 2개가 들어 왔을때 m을 넘길 수가 있다.

	그럼 다음 방법은 무엇?
	m/3에 근접한 값을 찾아 넣는다? 너무 근사치 아니냐

	이건어때
		m에 근접한 재일 큰 수를 넣는다

		그다음 근접한 제일 큰 수를 넣는다
		그다다음 근접한 제일 큰 수를 넣는다

		여기서 큰 수가 존재하지 않는경우
		이전 sequence에서 다음 큰 수를 넣는다.
		코드가 너무 김

	**세개 합을 계속 비교**가 제일 나을듯
*/