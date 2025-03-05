#include <iostream>
using namespace std;

int N, M;
int arr[100] = { 0, };

void solve(int cnt, int start) {
	if (cnt == M) {
		for (int i = 0; i < M; i++)
			cout << arr[i] << ' ';
		cout << '\n';
	}
	else {
		for (int i = start; i <= N; i++) {
			arr[cnt] = i;
			solve(cnt + 1, i); //i���� ���� start������ ���� start���� ���� ������ ���� �� ����. (i = start)
		}
	}
}

int main() {
	cin >> N >> M;
	solve(0, 1);
}