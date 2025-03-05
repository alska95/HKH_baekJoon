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
			solve(cnt + 1, i); //i값을 다음 start값으로 쓰면 start보다 작은 변수가 들어올 수 없다. (i = start)
		}
	}
}

int main() {
	cin >> N >> M;
	solve(0, 1);
}