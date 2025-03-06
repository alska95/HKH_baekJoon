#include <iostream>

using namespace std;

#define MAX 1010

int dp[MAX][MAX];
int candyMap[MAX][MAX];

int max(int a, int b, int c) {
	int arr[3] = { a , b , c };
	int biggest = 0;
	for (int i = 0; i < 3; i++) {
		if (arr[i] > biggest)
			biggest = arr[i];
	}
	return biggest;
}

int main() {
	int xNum, yNum;
	cin >> yNum >> xNum;

	for (int i = 1; i <= yNum; i++) {
		for (int j = 1; j <= xNum; j++) {
			cin >> candyMap[i][j];
		}
	}

	for (int i = 1; i <= yNum; i++) {
		for (int j = 1; j <= xNum; j++) {
			dp[i][j] = max(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + candyMap[i][j];

		}
	}
	cout << dp[yNum][xNum];
}