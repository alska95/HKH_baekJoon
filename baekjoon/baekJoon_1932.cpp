/*
정수 삼각형
내려올때 합이 최대
고려해야될 사항
a층
a-1층 ... a-(a-1)층까지 최대
모든 합을 구해보기
각 층의 정보를 저장하기
or 각 경로의 정보를 저장하기
*/

#include <cstdio>
using namespace std;

int get_max(int a, int b) { return a > b ? a : b; }
int main() {

	int n, i, j, max = 0;
	int dp[500][500] = { 0, };

	scanf("%d", &n);

	for (i = 0; i < n; i++) for (j = 0; j <= i; j++) scanf("%d", &dp[i][j]);

	for (i = 1; i < n; i++) {
		for (j = 0; j <= i; j++) {
			if (j == 0) dp[i][j] = dp[i - 1][0] + dp[i][j];
			else if (j == i) dp[i][j] = dp[i - 1][j - 1] + dp[i][j];
			else dp[i][j] = get_max(dp[i - 1][j - 1] + dp[i][j], dp[i - 1][j] + dp[i][j]);

			max = get_max(max, dp[i][j]);
		}
	}

	printf("%d\n", max);

	return 0;
}