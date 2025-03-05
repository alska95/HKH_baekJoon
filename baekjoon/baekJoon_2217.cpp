#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool comp(int a, int b) {
	return (a < b) ? 1 : 0;
}

int max(int a, int b) {
	return (a > b) ? a : b;
}


int main() {
	vector<int> weightRope;
	int ropeN;
	int tmp;
	cin >> ropeN;
	for (int i = 0; i < ropeN; i++) {
		cin >> tmp;
		weightRope.push_back(tmp);
	}
	sort(weightRope.begin(), weightRope.end(), comp);

	int selectedNum = ropeN;
	int result = weightRope[ropeN - 1];
	for (int i = 0; i < ropeN; i++) {
		int tmp = result;
		result = max(result, (ropeN - i) * weightRope[i]);
	}

	cout << result;
}

