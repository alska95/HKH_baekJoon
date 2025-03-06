/*
백준 2526 전깃줄
1번이 8번에 연결되면 1~8사용불가
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
	|arr[i][0] - arr[i][1]| +1 의 값이 dp[i]
	if( arr[i][0] < arr[i+1][1] < arr[i][1] --> overlaps) --> 카운트 +1

	lis알고리즘
	인풋값을 순서대로 정리하고 lis알고리즘을 적용하면 풀림.
	작은수부터 큰수로

	*/
}