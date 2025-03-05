#include <iostream>
using namespace std;

#define MAX 10001

int cardNum;
int cardPack[MAX];
int cardDp[MAX];

int max(int a, int b) {
	return (a > b) ? a : b;
}

int main() {



	cin >> cardNum;
	for (int i = 1; i <= cardNum; i++) {
		cin >> cardPack[i];
	}

	for (int i = 1; i <= cardNum; i++) { //dp[i] 는타겟(i)에 도달했을때의 최대가격
		for (int j = 0; j < i; j++) { //j개까지 모았을때의 최대가격
			for (int k = 1; k <= i; k++) { //k개짜리 팩의 가격
				if (i == j + k)
					cardDp[i] = max(cardDp[i], cardDp[j] + cardPack[k]);
			}
		}
	}

	cout << cardDp[cardNum];
}