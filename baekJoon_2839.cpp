#include <iostream>
using namespace std;

int dp[5001];

int min(int a, int b) {
	return (a < b) ? a : b;
}

int main() {
	int weight;
	cin >> weight;

	for (int i = 0; i < 5001; i++) {
		dp[i] = -1;
	}
	dp[3] = dp[5] = 1;
	for (int i = 6; i <= weight; i++) {
		for (int j = i - 6; j < i; j++) { // i-6부터 서치
			if (dp[j] != -1) {
				if (j + 5 == i)
					if (dp[i] != -1)
						dp[i] = min(dp[i], dp[j] + 1);
					else
						dp[i] = dp[j] + 1;
				if (j + 3 == i)
					if (dp[i] != -1)
						dp[i] = min(dp[i], dp[j] + 1);
					else
						dp[i] = dp[j] + 1;
			}

		}
	}

	cout << dp[weight];
}