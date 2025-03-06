#include <iostream>
using namespace std;

#define MAX 100001

int stickerNum, stickerVal[MAX][2];
int dp[MAX][2];

int max(int a, int b) {
	return (a > b) ? a : b;
}
int getValue() {
	dp[0][1] = stickerVal[0][1];
	dp[0][0] = stickerVal[0][0];
	dp[1][1] = dp[0][0] + stickerVal[1][1];
	dp[1][0] = dp[0][1] + stickerVal[1][0];
	for (int i = 2; i < stickerNum; i++) {
		dp[i][1] = max(dp[i - 2][0], dp[i - 1][0]) + stickerVal[i][1];
		dp[i][0] = max(dp[i - 2][1], dp[i - 1][1]) + stickerVal[i][0];
	}
	return max(dp[stickerNum - 1][0], dp[stickerNum - 1][1]);
}

void init() {
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < stickerNum; j++) {
			dp[i][j] = 0;
		}
	}
}


int main() {
	int testCase;
	cin >> testCase;

	for (int z = 0; z < testCase; z++) {
		cin >> stickerNum;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < stickerNum; j++) {
				cin >> stickerVal[j][i];
			}
		}

		cout << getValue() << '\n';
		init();
	}
}