#include <iostream>

using namespace std;

/*
��Ģ
������ steps = 0;
0���� 2�� �ִ� 2�� �ݺ��ؼ� a++
	stepCount if > 2 return false

1 2 3 4

124
24

5�� step / 4 way
12345

1245
135
235
245

6�� step / 5 way
123456

1246
1346
1356
2356
246

7�� step / 4 way
1234567

12457
12467
13467
1357

8�� step

12345678

12 45 78
12 4 6 8
13468
13568
13578
23568
23578
24578
2468

�켱 ù��° ��´�
�ݺ� (������ ��´� or 2���� ���� ��´�
������ ��´ٸ� 2�� �ݺ� or �����ڿ� �����ϰų� �Ѿ������)
*/

/*
0123
023
013

*/
int max(int a, int b) {
	return (a > b) ? a : b;
}

int main() {
	int stepNum;
	int steps[300];
	int dp[300];
	int count = 100;
	for (int i = 0; i < count; i++) {
		dp[i] = dp[i - 1] + dp[i - 3];
		dp[i] = dp[i - 2] + dp[i - 3];
	}

	cin >> stepNum;
	for (int i = 0; i < stepNum; i++) {
		cin >> steps[i];
	}

	dp[0] = steps[0];
	dp[1] = steps[0] + steps[1];
	dp[2] = max(steps[0] + steps[2], steps[1] + steps[2]);

	for (int i = 3; i < stepNum; i++) {
		dp[i] = max(dp[i - 2] + steps[i], dp[i - 3] + steps[i] + steps[i - 1]);
	}

	cout << dp[stepNum - 1];

}