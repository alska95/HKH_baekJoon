/*
������
(�� �ڸ��� ���� + �ڽ��� ��)���� �̷���� ������
���� ���� �ڽ��� �� �� �����ڸ� ã��


�־��� ��

1���� �־��� �� / 2 ���� ��������
�������� + ������
�������� �� �ڸ����� �� = �������� �̸� �����ڿ� ����


�ڸ��� ���ϴ¹�
tmpgiven�� 1���ڸ��� �ɶ����� ������
1�� �ڸ� ����Ǹ� ���� ���ڸ� 10���� ������
�ٽ� �ݺ�
*/
#include <iostream>
#include <cmath>
using namespace std;


void solve(int n) {

	int tmp = n;
	int tmp2 = 0;
	int count = 1;
	int construct = 0;

	while (tmp / 10 != 0) {
		tmp = tmp / 10;
		count++;
	}


	for (int i = n - count * 9; i < n; i++) {
		tmp = i;
		for (int j = 0; j < count; j++) {
			tmp2 = tmp2 + (tmp % 10);
			tmp = tmp / 10;
		}
		if (i + tmp2 == n) {
			construct = i;
			break;
		}
		tmp2 = 0;
	}
	cout << construct;
}
int main() {
	int n;
	cin >> n;
	solve(n);
}