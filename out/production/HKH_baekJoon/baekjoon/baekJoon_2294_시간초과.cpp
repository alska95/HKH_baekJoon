#include <iostream>
using namespace std;

#define max 10001
#define INF 2140000000

int dp[max];
int coin[max];
int min(int a, int b) {
	return (a < b) ? a : b;
}
int main() {

	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int n, target;

	cin >> n >> target;
	for (int i = 0; i < n; i++) {
		cin >> coin[i];
	}

	for (int i = 1; i <= n; i++) {
		dp[i] = INF;
	}


	for (int i = 1; i <= target; i++) {
		for (int j = 0; j < i; j++) {
			for (int k = 0; k < n; k++) {
				if (j + coin[k] == i)
					dp[i] = min(dp[i], dp[j] + 1);
			}
		}
	}
	if (dp[n] == INF)
		cout << -1;
	else
		cout << dp[n];
}