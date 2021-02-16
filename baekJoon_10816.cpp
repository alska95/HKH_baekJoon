#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	vector<int> arr;
	int N, x;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> x;
		arr.push_back(x);
	}
	int M;
	cin >> M;

	sort(arr.begin(), arr.end());
	for (int i = 0; i < M; i++) {
		cin >> x;
		cout << lower_bound(arr.begin(), arr.end(), x + 1) - lower_bound(arr.begin(), arr.end(), x) << ' ';
	}

}
