#include <iostream>
#include <algorithm>
using namespace std;


//1149 rgb�Ÿ�
/*
1 != 2
n != n-1
ó���� ���� , �������� ������ �� ������ �޶���Ѵ�.
�׿��� ������ rgb�� �������� ����

rgb�� ������ ���� �� ���� ��� ���� �� �ּҰ��� ���Ѵ�?
rgb , rbg , brg , bgr , gbr , grb
*/

int tempRGB[1000][3];
int houseNum;

int main() {

	int n, r, g, b;
	int cost[1001][3];

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {

		scanf("%d %d %d", &cost[i][0], &cost[i][1], &cost[i][2]);
	}

	int dp[1001][3] = { 0 };

	dp[0][0] = cost[0][0];
	dp[0][1] = cost[0][1];
	dp[0][2] = cost[0][2];

	for (int i = 1; i < n; i++) {
		dp[i][0] += min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
		dp[i][1] += min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
		dp[i][2] += min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
	}

	int ans = min(dp[n - 1][2], min(dp[n - 1][0], dp[n - 1][1]));
	printf("%d", ans);

	return 0;
}