#include <iostream>
#include <queue>
using namespace std;
#define MAX 51
int visited[MAX][MAX], landScape[MAX][MAX], xNum, yNum;

int dx[8] = { 0, 0, -1, 1 , 1 , -1 ,1 , -1 };
int dy[8] = { 1 ,-1 ,0, 0 ,1 , -1 , -1 , 1 };


void islandDfs(int i, int j) {
	visited[i][j] = 1;
	int y = i;
	int x = j;
	for (int k = 0; k < 8; k++) {
		int newX = x + dx[k];
		int newY = y + dy[k];
		if (newX >= xNum || newX < 0 || newY >= yNum || newY < 0)
			continue;
		if (visited[newY][newX] == 0 && landScape[newY][newX] == 1) {
			visited[newY][newX] = 1;
			islandDfs(newY, newX);
		}
	}
}


int main() {
	xNum = yNum = -1;

	while (1) {
		cin >> xNum >> yNum;

		if (xNum == 0 && yNum == 0)
			break;

		for (int i = 0; i < yNum; i++) {
			for (int j = 0; j < xNum; j++) {
				cin >> landScape[i][j];
			}
		}

		int counter = 0;
		for (int i = 0; i < yNum; i++) {
			for (int j = 0; j < xNum; j++) {
				if (visited[i][j] == 0 && landScape[i][j] == 1) {
					islandDfs(i, j);
					counter++;
				}

			}
		}
		cout << counter << '\n';
		for (int i = 0; i < yNum; i++) {
			for (int j = 0; j < xNum; j++) {
				visited[i][j] = 0;
			}
		}
	}
}