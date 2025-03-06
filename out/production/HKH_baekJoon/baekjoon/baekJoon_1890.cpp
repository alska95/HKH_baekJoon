#include <iostream>
using namespace std;

#define MAX 110

long long boardSize;
long long gameBoard[MAX][MAX];

long long dp[MAX][MAX];
long long dx[2] = { 0 , 1 };
long long dy[2] = { 1, 0 };


void solve(long long y, long long x) {
	long long index = gameBoard[y][x];
	if (index == 0)
		return;
	for (long long i = 0; i < 2; i++) {
		long long newX = dx[i] * index + x;
		long long newY = dy[i] * index + y;
		if (newX >= boardSize || newY >= boardSize)
			continue;
		else dp[newY][newX] += dp[y][x];
	}
}


int main() {
	cin >> boardSize;
	for (long long i = 0; i < boardSize; i++) {
		for (long long j = 0; j < boardSize; j++) {
			cin >> gameBoard[i][j];
		}
	}

	dp[0][0] = 1;

	for (long long i = 0; i < boardSize; i++) {
		for (long long j = 0; j < boardSize; j++) {
			solve(i, j);
		}
	}

	cout << dp[boardSize - 1][boardSize - 1];
}