#include <iostream>
#include <queue>
#define max 102

using namespace std;

int tomatoFarm[max][max][max], dayCount[max][max][max];

int dx[6] = { 0, 0 ,0 , 0 , 1 , -1 };
int dy[6] = { 0, 0, 1 , -1 , 0 , 0 };
int dz[6] = { 1 , -1 , 0 , 0, 0 , 0 };

int xNum, yNum, zNum, totalDays;

struct Tomatos {
	int z, y, x;
};

queue<Tomatos> tomatoQ;

void ripeTomato() {

	while (!tomatoQ.empty()) {
		int x = tomatoQ.front().x;
		int y = tomatoQ.front().y;
		int z = tomatoQ.front().z;
		tomatoQ.pop();

		for (int i = 0; i < 6; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			int newZ = z + dz[i];

			if (newX < 0 || newY < 0 || newZ < 0 || newX >= xNum || newY >= yNum || newZ >= zNum)
				continue;
			if (tomatoFarm[newZ][newY][newX] == 0 && dayCount[newZ][newY][newX] == 0) {
				dayCount[newZ][newY][newX] = dayCount[z][y][x] + 1;
				tomatoQ.push({ newZ , newY , newX });
			}

		}
	}
}

void insertTomato() {
	for (int i = 0; i < zNum; i++) {
		for (int j = 0; j < yNum; j++) {
			for (int k = 0; k < xNum; k++) {
				cin >> tomatoFarm[i][j][k];
				if (tomatoFarm[i][j][k] == 1)
					tomatoQ.push({ i , j , k });
			}
		}
	}
}

int main() {
	cin >> xNum >> yNum >> zNum;

	insertTomato();

	ripeTomato();

	for (int i = 0; i < zNum; i++) {
		for (int j = 0; j < yNum; j++) {
			for (int k = 0; k < xNum; k++) {
				if (tomatoFarm[i][j][k] == 0 && dayCount[i][j][k] == 0) {
					cout << -1;
					return 0;
				}
				if (totalDays < dayCount[i][j][k])
					totalDays = dayCount[i][j][k];
			}
		}
	}

	cout << totalDays;
}