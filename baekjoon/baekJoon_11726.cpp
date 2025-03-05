#include <iostream>
using namespace std;

#define max 1000

int dp[max];



int main() {
	dp[1] = 1;
	dp[2] = 2;
	int number;
	cin >> number;
	for (int i = 3; i <= number; i++) {
		for (int j = i - 2; j <= i; j++) {
			if (j + 1 == i)
				dp[i] += dp[j];
			if (j + 2 == i)
				dp[i] += dp[j];
			dp[i] %= 10007;
		}
	}
	cout << dp[number];
}