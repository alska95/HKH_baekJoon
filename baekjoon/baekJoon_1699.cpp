#include <iostream>
using namespace std;

int dp[100001];

int min(int a, int b) {
	return (a < b) ? a : b;
}

int main() {
	int N;
	cin >> N;


	for (int i = 1; i <= N; i++) {
		for (int j = 1; j * j <= i; j++) {
			if (dp[i] != 0)
				dp[i] = min(dp[i], dp[i - j * j] + 1);
			else
				dp[i] = dp[i - j * j] + 1;
		}
	}

	cout << dp[N];
}