#include <iostream>
using namespace std;

int arr[1001];
int dp[1001];

int max(int a, int b) {
	return (a > b) ? a : b;
}

int main() {
	int size;
	cin >> size;
	for (int i = 0; i < size; i++) {
		cin >> arr[i];
	}


	dp[0] = 1;
	for (int i = 1; i < size; i++) {
		dp[i] = 1;
		for (int j = i - 1; j >= 0; j--) {
			if (arr[j] > arr[i]) { // 만약 이전 수중 나보다 큰 수를 찾는다면
				dp[i] = max(dp[i], dp[j] + 1); //해당 인덱스의 dp+1과 현재 dp를 비교.
			}
		}
	}

	int result = 0;
	for (int i = 0; i < size; i++) {
		result = max(result, dp[i]);
	}

	cout << result;

}