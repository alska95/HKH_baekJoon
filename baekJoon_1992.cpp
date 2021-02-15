#include <iostream>
using namespace std;

//쿼드트리 색종이 만들기
#define MAX 129

string map[10];
int blueCount, whiteCount;
string graphics;

void makePaper(int y, int x, int size) {
	int oneFlag = 0, zeroFlag = 0;
	for (int i = y; i < y + size; i++) {
		for (int j = x; j < x + size; j++) {
			if (map[i][j] == '1')
				oneFlag = 1;
			else if (map[i][j] == '0')
				zeroFlag = 1;
		}
	}
	if (oneFlag == 1 && zeroFlag == 1) {
		graphics += "(";
		makePaper(y, x, size / 2);
		makePaper(y, x + size / 2, size / 2);
		makePaper(y + size / 2, x, size / 2);
		makePaper(y + size / 2, x + size / 2, size / 2);
		graphics += ")";
	}
	else if (oneFlag == 1)
		graphics += "1";
	else if (zeroFlag == 1)
		graphics += "0";

}

int main() {

	int N;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> map[i];
	}
	makePaper(0, 0, N);
	cout << graphics;
}