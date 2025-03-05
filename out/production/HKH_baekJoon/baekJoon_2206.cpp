#include <iostream>
#include <queue>
#define max 1002
using namespace std;

struct map {
	int y, x, breakable;
};
int dx[4] = { 0 ,0 , -1 ,1 };
int dy[4] = { 1, -1 , 0 ,0 };
int yNum, xNum, result, shortestCut[max][max][2]; // shortestCut[y][x][1] == 부쉈는지여부
string wallMap[max];
queue<map> mapQ;


int findEnd() {
	shortestCut[0][0][1] = 1;
	mapQ.push({ 0, 0 , 1 });
	while (!mapQ.empty()) {
		int x = mapQ.front().x;
		int y = mapQ.front().y;
		int breakable = mapQ.front().breakable;
		mapQ.pop();
		if (x == xNum - 1 && y == yNum - 1) {
			return shortestCut[y][x][breakable];
		}

		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			if (newX < 0 || newX >= xNum || newY < 0 || newY >= yNum)
				continue;
			if (wallMap[newY][newX] == '1' && breakable == 1) { //벽을 부순적이 없고 벽을 만났으며 가본적 없는곳
				shortestCut[newY][newX][0] = shortestCut[y][x][1] + 1;
				mapQ.push({ newY , newX  , 0 });
			}
			if (wallMap[newY][newX] != '1' && shortestCut[newY][newX][breakable] == 0) { //(벽을 부쉈는지는 상관 x 벽을 안만났으며 가본적 없는곳
				shortestCut[newY][newX][breakable] = shortestCut[y][x][breakable] + 1;
				mapQ.push({ newY , newX , breakable });
			}
		}
	}
	return -1;
}

int main() {
	cin >> yNum >> xNum;
	for (int i = 0; i < yNum; i++) {
		cin >> wallMap[i];
	}
	cout << findEnd() << '\n';

}