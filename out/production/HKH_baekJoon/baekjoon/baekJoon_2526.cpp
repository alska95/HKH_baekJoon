/*
���� 2526 ������
1���� 8���� ����Ǹ� 1~8���Ұ�
*/
#include <iostream>
using namespace std;

int main() {
	int count = 0;
	int arr[500];
	int dp[500];
	int result = 0;

	for (int i = 0; i < 500; i++) {
		arr[i] = 0;
	}

	cin >> count;

	for (int i = 0; i < count; i++) {
		int target = 0;
		cin >> target;
		cin >> arr[target];
	}

	for (int i = 0; i < 500; i++) {
		dp[i] = 1;
		for (int j = 0; j < i; j++) {
			if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
		}
	}

	for (int i = 0; i < 500; i++) {
		if (dp[i] > result) result = dp[i];
	}

	cout << count - result + 1;
	/*
	|arr[i][0] - arr[i][1]| +1 �� ���� dp[i]
	if( arr[i][0] < arr[i+1][1] < arr[i][1] --> overlaps) --> ī��Ʈ +1

	lis�˰���
	��ǲ���� ������� �����ϰ� lis�˰����� �����ϸ� Ǯ��.
	���������� ū����

	*/
}