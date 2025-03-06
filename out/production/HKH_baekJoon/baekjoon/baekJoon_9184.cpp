/*
if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns:
	1

if a > 20 or b > 20 or c > 20, then w(a, b, c) returns:
	w(20, 20, 20)

if a < b and b < c, then w(a, b, c) returns:
	w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)

otherwise it returns:
	w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
*/
#include <iostream>
using namespace std;

int dp[30][30][30];

int w(int a, int b, int c) {

	if (a <= 0 || b <= 0 || c <= 0)
		return 1;
	if (a > 20 || b > 20 || c > 20)
		return w(20, 20, 20);
	if (dp[a][b][c] != -1)
		return dp[a][b][c];
	if (a < b && b < c)
		return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
	else
		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
}


int main() {
	int a = 0, b = 0, c = 0;
	for (int i = 0; i < 30; i++) {
		for (int j = 0; j < 30; j++) {
			for (int k = 0; k < 30; k++) {
				dp[i][j][k] = -1;
			}
		}
	}

	while (1) {
		cin >> a >> b >> c;
		if (a == -1 && b == -1 && c == -1)
			break;
		printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
	}
}