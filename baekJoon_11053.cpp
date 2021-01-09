/*
���� �� �����ϴ� �κ� ����

�� dp 1�� �ʱ�ȭ
���� arr���� arr[count]���� ���� ���� �ְ�, dp[count]�� ������ ūdp���� ���ϰ� �ִٸ�
dp�� set
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