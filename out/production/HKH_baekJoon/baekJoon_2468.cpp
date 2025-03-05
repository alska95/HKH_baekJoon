#include <iostream>
using namespace std;

#define MAX 101


int isFlooded[MAX][MAX];
int map[MAX][MAX], areaNum;

int visited[MAX][MAX];
int securedNum[MAX];



int dx[4] = { 0, 0 ,1 ,-1 };
int dy[4] = { 1, -1 , 0 , 0 };


void init() {
	for (int i = 0; i < areaNum; i++) {
		for (int j = 0; j < areaNum; j++) {
			visited[i][j] = 0;
		}
	}
}

void floodDFS(int floodLimit, int y, int x) {
	for (int i = 0; i < 4; i++) {
		int newX = x + dx[i];
		int newY = y + dy[i];
		if (newX < 0 || newX >= areaNum || newY < 0 || newY >= areaNum)
			continue;
		if (visited[newY][newX] == 0 && map[newY][newX] > floodLimit) {
			visited[newY][newX] = 1;
			floodDFS(floodLimit, newY, newX);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> areaNum;
	for (int i = 0; i < areaNum; i++) {
		for (int j = 0; j < areaNum; j++) {
			cin >> map[i][j];
		}
	}


	int endCount;
	for (int height = 1; height <= 100; height++) {
		init();
		int counter = 0;
		for (int i = 0; i < areaNum; i++) {
			for (int j = 0; j < areaNum; j++) {
				if (visited[i][j] == 0 && map[i][j] > height) {

					visited[i][j] = 1;
					counter++;
					floodDFS(height, i, j);
				}

			}
		}
		if (counter == 0) {
			endCount = height;
			break;
		}
		securedNum[height] = counter;
	}

	int most = 1;
	for (int i = 1; i <= MAX; i++) {
		if (securedNum[i] > most) {
			most = securedNum[i];
		}
	}

	cout << most;
}