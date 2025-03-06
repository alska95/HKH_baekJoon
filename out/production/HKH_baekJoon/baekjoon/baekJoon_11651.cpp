#include <vector>
#include <algorithm>
#include <utility>
#include <iostream>

using namespace std;

bool sortbysec(const pair<int, int>& a, const pair<int, int>& b) {
	if (a.second == b.second) return(a.first < b.first);
	return(a.second < b.second);
}

int main() {
	int n, j, i, k;
	vector<pair<int, int>> v;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> j >> k;
		v.push_back(pair<int, int>(j, k));
	}
	sort(v.begin(), v.end(), sortbysec);

	for (int i = 0; i < n; i++) {
		cout << v[i].first << ' ' << v[i].second << '\n';
	}
}