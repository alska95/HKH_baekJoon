#include <iostream>
#include <queue>
#include <utility>

#define max 1001

using namespace std;

int xNum, yNum, dayCount[max][max], tomatoFarm[max][max];

int dx[4] = { 0,0 , 1 ,-1 };
int dy[4] = { 1, -1 , 0 , 0 };

queue<pair<int, int>> tomatoQ;

void ripeTomato() {

	while (!tomatoQ.empty()) {
		int x = tomatoQ.front().second;
		int y = tomatoQ.front().first;
		tomatoQ.pop();
		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			if (newX < 0 || newY < 0 || newX >= xNum || newY >= yNum)
				continue;
			if (tomatoFarm[newY][newX] == 0 && dayCount[newY][newX] == 0) {
				dayCount[newY][newX] = dayCount[y][x] + 1;
				tomatoQ.push(make_pair(newY, newX));
			}


		}
	}
}


int main() {

	int totalDays = 0;

	cin >> xNum >> yNum;
	for (int i = 0; i < yNum; i++) {
		for (int j = 0; j < xNum; j++) {
			cin >> tomatoFarm[i][j];
			if (tomatoFarm[i][j] == 1)
				tomatoQ.push(make_pair(i, j));
		}
	}

	ripeTomato();

	for (int i = 0; i < yNum; i++) {
		for (int j = 0; j < xNum; j++) {
			if (dayCount[i][j] == 0 && tomatoFarm[i][j] == 0) {
				cout << -1;
				return 0;
			}

			if (dayCount[i][j] > totalDays)
				totalDays = dayCount[i][j];
		}
	}

	cout << totalDays;
}