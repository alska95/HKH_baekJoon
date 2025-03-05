/*
퀸이 안겹치는 경우의 수
x축 불가능 = if(selectedx) continue
y축 불가능 = if(selectedy) continue
대각 불가능 = 현재좌표 - x == 현재y - y면 대각 동치
*/

#include <iostream>

using namespace std;

int N;
int vx[16], vy[16];


int solve(int y, int x) {
	for (int i = 0; i < y; i++) {
		if (y == vy[i]) return 0;
		if (x == vx[i]) return 0;
		if (abs(x - vx[i]) == abs(y - vy[i]))return 0;
	}
	if (y == N - 1) {
		return 1;
	}
	vx[y] = x; vy[y] = y;
	int r = 0;
	for (int i = 0; i < N; i++) {
		r += solve(y + 1, i);
	}
	return r;
}

int main() {
	cin >> N;
	int r = 0;
	for (int i = 0; i < N; i++) r += solve(0, i);
	cout << r;
}