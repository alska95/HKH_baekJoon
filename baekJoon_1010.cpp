#include <iostream>
using namespace std;

#define MAX 31

int dp[MAX][MAX];


int main()
{
	for (int i = 0; i < 31; i++)
	{
		for (int j = 0; j < 31; j++) {
			dp[i][j] = 0;
		}
	}

	for (int i = 0; i < 31; i++)
	{
		dp[1][i] = i;
	}

	for (int i = 2; i < 31; i++)
	{
		for (int k = i; k < 31; k++)
		{
			for (int l = k - 1; l >= i - 1; l--) {
				dp[i][k] += dp[i - 1][l];
			}
		}
	}
	int testCase;
	cin >> testCase;
	int N, M;
	for (int i = 0; i < testCase; i++)
	{
		cin >> N >> M;

		cout << dp[N][M] << '\n';
	}
}
