#include <iostream>
#define MAX 51

using namespace std;

int nodeRowNum, nodeColNum, node[MAX][MAX], visited[MAX][MAX];

int dx[4] = { 0 ,1,0,-1 };
int dy[4] = { 1,0,-1,0 };

void dfsFarm(int y, int x) {

	visited[y][x] = 1;

	for (int i = 0; i < 4; i++) {
		int newX = dx[i] + x;
		int newY = dy[i] + y;

		if (newX < nodeColNum && newX >= 0 && newY < nodeRowNum && newY >= 0) {
			if (visited[newY][newX] != 1 && node[newY][newX] == 1) {
				//visited[newY][newX] = 1;
				dfsFarm(newY, newX);
			}

		}
	}
}


int main() {
	int testCase;
	int x, y;
	int farmCounter[1000] = { 0, };
	int vaccine;

	cin >> testCase;
	///////////////////////////
	for (int z = 0; z < testCase; z++) {
		cin >> nodeColNum >> nodeRowNum >> vaccine;

		for (int i = 0; i < vaccine; i++) {
			cin >> x >> y;
			node[y][x] = 1;
		}

		for (int i = 0; i < nodeRowNum; i++) {
			for (int j = 0; j < nodeColNum; j++) {
				if (visited[i][j] != 1 && node[i][j] == 1) {
					//visited[i][j] = 1;
					farmCounter[z]++;
					dfsFarm(i, j);
				}
			}
		}
	}
	///////////////////////////
	for (int i = 0; i < testCase; i++) {
		cout << farmCounter[i] << '\n';
	}
}