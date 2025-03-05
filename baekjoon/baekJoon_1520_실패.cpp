#include <iostream>
#include <queue>
#include <vector>
using namespace std;

#define MAX 510

int dp[MAX][MAX];
int map[MAX][MAX];
int visited[MAX][MAX];
int xNum, yNum;
int dx[4] = { 0 , -1  , 0 , 1 };
int dy[4] = { -1 , 0  , 1 , 0 };

struct cord {
	int y, x;
};



void solveDfs(int y, int x) {

	for (int i = 0; i < 4; i++) {

		int newX = dx[i] + x;
		int newY = dy[i] + y;
		if (newX > xNum || newX < 1 || newY > xNum || newY < 1 || visited[newY][newX] == 1 || map[newY][newX] <= map[y][x]) {
			continue;
		}
		else {
			dp[newY][newX] += 1;
			visited[newY][newX] = 1;
			solveDfs(newY, newX);
			visited[newY][newX] = 0;
		}
	}
}


int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> yNum >> xNum;
	for (int i = 1; i <= yNum; i++) {
		for (int j = 1; j <= xNum; j++) {
			cin >> map[i][j];
		}
	}

	visited[yNum][xNum] = 1;
	dp[yNum][xNum] = 1;
	solveDfs(yNum, xNum);
	//for (int i = 1; i <= yNum; i++) {
	//	for (int j = 1; j <= xNum; j++) {
	//		cout << dp[i][j] << ' ';
	//	}
	//	cout << '\n';
	//}
	cout << dp[1][1];

}