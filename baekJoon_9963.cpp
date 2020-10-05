/*
���� �Ȱ�ġ�� ����� ��
x�� �Ұ��� = if(selectedx) continue
y�� �Ұ��� = if(selectedy) continue
�밢 �Ұ��� = ������ǥ - x == ����y - y�� �밢 ��ġ
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