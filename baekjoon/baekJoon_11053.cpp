/*
가장 긴 증가하는 부분 수열

각 dp 1로 초기화
만약 arr값중 arr[count]보다 낮은 값이 있고, dp[count]의 값보다 큰dp값을 지니고 있다면
dp로 set
*/

#include <iostream>
using namespace std;


int max(int a, int b) {
	return (a > b) ? a : b;
}
int main() {
	int count;
	cin >> count;

	int arr[1005];
	int dp[1001];
	int highestArr = 1;

	for (int i = 0; i < count; i++) {
		cin >> arr[i];
		dp[i] = 1;
	}

	for (int i = 0; i < count; i++) {
		for (int j = 0; j < i; j++) {
			if (arr[j] < arr[i]) {
				dp[i] = max(dp[i], dp[j] + 1);
			}
		}
		highestArr = max(dp[i], highestArr);
	}

	cout << highestArr;


}