#include <iostream>
using namespace std;

//쿼드트리 색종이 만들기
#define MAX 129

int quardTree[MAX][MAX];
int blueCount, whiteCount;

void makePaper(int y, int x, int size) {
	int blueFlag = 0, whiteFlag = 0;
	for (int i = y; i < y + size; i++) {
		for (int j = x; j < x + size; j++) {
			if (quardTree[i][j] == 1)
				blueFlag = 1;
			else if (quardTree[i][j] == 0)
				whiteFlag = 1;
		}
	}
	if (blueFlag == 1 && whiteFlag == 1) {
		makePaper(y, x, size / 2);
		makePaper(y + size / 2, x, size / 2);
		makePaper(y, x + size / 2, size / 2);
		makePaper(y + size / 2, x + size / 2, size / 2);
	}
	else if (blueFlag == 1)
		blueCount++;
	else if (whiteFlag == 1)
		whiteCount++;
}

int main() {
	int N;
	cin >> N;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> quardTree[i][j];
		}
	}
	makePaper(1, 1, N);
	cout << whiteCount << '\n' << blueCount;
}