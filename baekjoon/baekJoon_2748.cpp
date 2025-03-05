#include <iostream>

using namespace std;

long long arr[100] = { 0, };

long long solve(int n) {
	if (n < 0) return 0;
	if (n <= 1) {
		return n;
	}
	else {
		if (arr[n] != 0) return arr[n];
		arr[n - 1] = solve(n - 1);
		arr[n - 2] = solve(n - 2);
		return solve(n - 1) + solve(n - 2);
	}
}

int main() {
	int n;
	cin >> n;
	cout << solve(n);

}