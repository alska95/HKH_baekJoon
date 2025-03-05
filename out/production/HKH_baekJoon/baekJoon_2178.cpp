#include <iostream>
#include <queue>
#include <utility>

#define max 101
using namespace std;

string path[max];
int xNum, yNum, shortestCut[max][max], visited[max][max];

int dx[4] = { 0 ,0, 1 ,-1 };
int dy[4] = { 1,-1,0,0 };

void findPath(int i, int j) {
	visited[i][j] = 1;
	queue<pair<int, int>> bfsQ;
	bfsQ.push(make_pair(i, j));

	while (!bfsQ.empty()) {
		int x = bfsQ.front().second;
		int y = bfsQ.front().first;

		bfsQ.pop();
		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			if (newX < 0 || newX >= xNum || newY < 0 || newY >= yNum)
				continue;
			if (visited[newY][newX] != 1 && shortestCut[newY][newX] == 0 && path[newY][newX] == '1') {
				shortestCut[newY][newX] = shortestCut[y][x] + 1;
				visited[newY][newX] = 1;
				bfsQ.push(make_pair(newY, newX));
			}
		}
	}
}

int main() {

	cin >> yNum >> xNum;
	for (int i = 0; i < yNum; i++) {
		cin >> path[i];
	}
	findPath(0, 0);
	cout << shortestCut[yNum - 1][xNum - 1] + 1;
}