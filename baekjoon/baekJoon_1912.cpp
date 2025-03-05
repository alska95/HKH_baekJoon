/*
총합을 dp에 저장하자.
dp i - 1 이 arr [i] 보다 작으면
dp [ i ] = arr[i]
else
dp[i] = max(dp[i] + arr[i] , dp[i]);
*/

#include <iostream>
using namespace std;

int max(int a, int b) {
	return (a > b) ? a : b;
}

int main() {
	int count;
	int arr[100001];
	int dp[100001] = { 0 , };
	int biggest = -1001;


	cin >> count;

	for (int i = 1; i <= count; i++) {
		cin >> arr[i];

	}

	for (int i = 1; i <= count; i++) {
		dp[i] = max(dp[i - 1] + arr[i], arr[i]);
	}

	for (int i = 1; i <= count; i++)
		biggest = max(biggest, dp[i]);
	cout << biggest;
}