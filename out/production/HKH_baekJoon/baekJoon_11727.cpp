#include <iostream>
using namespace std;
#define max 1001

int dp[max];

int main() {

	dp[1] = 1;
	dp[2] = 3;
	int number;
	cin >> number;
	for (int i = 3; i <= number; i++) {
		for (int j = i - 2; j < i; j++) {
			if (j + 1 == i)
				dp[i] += dp[j];
			if (j + 2 == i)
				dp[i] += dp[j] * 2;
			dp[i] %= 10007;
		}
	}

	cout << dp[number];
}