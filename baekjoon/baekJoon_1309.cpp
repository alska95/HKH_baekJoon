#include <iostream>
using namespace std;
#define MAX 100010

int dp[MAX][3]; // 0에 하나도 안채움 , 1에 좌측하나 채움 , 2에 우측 하나 채움
int sizeD;

int main() {
	cin >> sizeD;
	for (int i = 0; i < 3; i++) {
		dp[0][i] = 1;
	}
	for (int i = 1; i < sizeD; i++) {
		dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
		dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
		dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
	}

	int sum = 0;
	for (int i = 0; i < 3; i++) {
		sum += dp[sizeD - 1][i] % 9901;
	}
	cout << sum % 9901;

}