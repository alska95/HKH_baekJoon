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
	start : 시작점  to : 도착점  bypass : 경유점(2번째 봉)
	모두 동일한 절차를 따른다
	n-1개의 원판을 3번 봉을 거쳐 2번으로 옮기고
	1번 가장 큰 원판을 3번으로
	2번 n-1개의 원판을 1번 장대를 거쳐 3번으로
*/