#include <iostream>
using namespace std;

#define max 91

long long dp[max][2];



int main() {
	int number;
	cin >> number;
	dp[1][1] = 1;
	dp[2][0] = 1;
	for (int i = 3; i <= number; i++) {
		dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
		dp[i][1] = dp[i - 1][0];
	}
	cout << dp[number][0] + dp[number][1];

}