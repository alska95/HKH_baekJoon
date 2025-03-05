#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<int, int>a, pair<int, int>b) {
	if (a.second == b.second) {
		return a.first < b.first;
	}
	else {
		return a.second < b.second;
	}
}

int main() {
	vector<pair<int, int>>v;
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		v.push_back({ a,b });
	}
	sort(v.begin(), v.end(), compare);

	int cnt = 0;
	int now = v[0].second;
	for (int i = 1; i < n; i++) {
		if (v[i].first >= now) {
			cnt++;
			now = v[i].second;
		}
	}

	cout << cnt + 1;
}