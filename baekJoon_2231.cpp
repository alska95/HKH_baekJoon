/*
분해합
(각 자리의 총합 + 자신의 값)으로 이루어진 수에서
가장 작은 자신의 값 즉 생성자를 찾기


주어진 수

1부터 주어진 수 / 2 까지 빼나간다
빼나간수 + 남은수
남은수의 각 자릿수의 합 = 빼나간수 이면 생성자에 저장


자리수 구하는법
tmpgiven이 1의자리가 될때까지 나눈다
1의 자리 추출되면 원래 숫자를 10으로 나눈다
다시 반복
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