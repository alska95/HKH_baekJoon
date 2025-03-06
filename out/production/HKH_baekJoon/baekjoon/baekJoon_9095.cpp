#include <iostream>
using namespace std;

#define max 12

int dp[max];
bool visited[max];



int main() {
	int testCase;
	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;
	cin >> testCase;
	for (int i = 0; i < testCase; i++) {
		int number = 0;
		cin >> number;
		for (int i = 4; i <= number; i++) { //목표하는 수
			for (int j = i - 3; j <= i; j++) { //비교하는 수
				for (int k = 1; k <= 3; k++) { // 더하는 수
					if (!visited[i] && j + k == i)
						dp[i] += dp[j];
				}
			}
		}

		cout << dp[number] << '\n';
		for (int i = 1; i <= number; i++) {
			visited[i] = true;
		}
	}


}