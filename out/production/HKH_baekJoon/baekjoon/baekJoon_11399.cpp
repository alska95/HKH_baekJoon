#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int N;
	cin >> N;
	int arr[1001] = { 0, };
	int sum[1001] = { 0, };
	int total = 0;

	for (int i = 1; i <= N; i++) {
		cin >> arr[i];
	}

	sort(arr + 1, arr + N + 1);
	for (int i = 1; i <= N; i++) {
		sum[i] = sum[i - 1] + arr[i];
	}

	for (int i = 1; i <= N; i++) {
		total += sum[i];
	}
	cout << total;
}
