#include <iostream>
using namespace std;

void solve(int n) {
	int a[10] = { 0, };

	for (; n > 0; n = n / 10) {
		a[n % 10]++;
	}
	for (int i = 9; i >= 0; i--) {
		while (a[i]--) cout << i;
	}
}

int main() {
	int n;
	cin >> n;
	solve(n);
}



