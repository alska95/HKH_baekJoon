#include <iostream>

using namespace std;

int M, N;
int arr[100] = { 0, };

void solve(int cnt) {
	if (cnt == M) {
		for (int i = 0; i < M; i++) {
			cout << arr[i] << ' ';
		}
		cout << '\n';
	}
	else {
		for (int i = 1; i <= N; i++) {
			arr[cnt] = i;
			solve(cnt + 1);
		}
	}
}

int main() {
	cin >> N >> M;
	solve(0);
}