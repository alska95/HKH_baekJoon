#include <iostream>
#include <algorithm>
using namespace std;

int arr[500001];
int target;

void solve(int start, int end, int target) {
	int counter = 0;
	int mid = (start + end) / 2;
	if (start >= end) {
		if (arr[mid] != target) {
			cout << counter << ' ';
			return;
		}
	}
	if (arr[mid] == target) {
		while (arr[mid] == target) {
			mid--;
		}
		mid++;
		while (arr[mid] == target) {
			counter++;
			mid++;
		}
		cout << counter << ' ';
	}
	else if (arr[mid] < target) {
		solve(mid + 1, end, target);
	}
	else if (arr[mid] > target) {
		solve(start, mid - 1, target);
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	sort(arr, arr + N);


	int M;
	cin >> M;
	for (int i = 0; i < M; i++) {
		cin >> target;
		solve(0, N - 1, target);
	}


}
