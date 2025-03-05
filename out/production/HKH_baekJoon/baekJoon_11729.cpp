#include <iostream>
#include <cmath>

using namespace std;

void hanoi(int n, int start, int to, int bypass) {
	if (n == 1) {
		cout << start << ' ' << to << '\n';
	}
	else {
		hanoi(n - 1, start, bypass, to);
		cout << start << ' ' << to << '\n';
		hanoi(n - 1, bypass, to, start);
	}
}

int main() {
	int n;
	cin >> n;

	int result = pow(2, n) - 1;

	cout << result << '\n';
	hanoi(n, 1, 3, 2);
}

/*
	start : ������  to : ������  bypass : ������(2��° ��)
	��� ������ ������ ������
	n-1���� ������ 3�� ���� ���� 2������ �ű��
	1�� ���� ū ������ 3������
	2�� n-1���� ������ 1�� ��븦 ���� 3������
*/