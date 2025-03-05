#include <iostream>
using namespace std;

int dp[1001];
int arr[1001];


int max(int a, int b) {
	return (a > b) ? a : b;
}

int main() {
	int arrSize;
	cin >> arrSize;
	for (int i = 0; i < arrSize; i++) {
		cin >> arr[i];
	}

	dp[0] = arr[0];

	for (int i = 1; i < arrSize; i++) { //���� ���� ������ dp�ε���
		for (int j = i - 1; j >= 0; j--) { //���ϴ� ���������� index
			if (arr[j] < arr[i]) {
				dp[i] = max(dp[j], dp[i]);
			}
		}
		dp[i] += arr[i];
	}
	int result = 0;
	for (int i = 0; i < arrSize; i++) {
		result = max(dp[i], result);
	}

	cout << result;
}