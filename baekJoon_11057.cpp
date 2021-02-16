#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int upN;
int dp[1001][10];


void solveDp() {
	for (int z = 0; z < 10; z++) {
		dp[1][z] = 1;
	}
	for (int i = 2; i <= upN; i++) {
		for (int j = 0; j < 10; j++) {
			for (int k = 0; k <= j; k++) {
				dp[i][j] += dp[i - 1][k] % 10007;
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> upN;

	solveDp();

	int result = 0;
	for (int z = 0; z < 10; z++) {
		result += dp[upN][z];
		result %= 10007;
	}
	cout << result;
}
