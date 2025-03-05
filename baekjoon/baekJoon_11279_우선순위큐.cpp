#include <iostream>
#include <queue>
#include <vector>
using namespace std;

struct cmp {
	bool operator()(int a, int b) {
		return a < b;
	}
};
priority_queue<int, vector<int>, cmp> heapQ;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);


	int N;
	cin >> N;
	int x;
	for (int i = 0; i < N; i++) {
		cin >> x;
		if (x == 0) {
			if (heapQ.empty())
				cout << 0 << '\n';
			else {
				cout << heapQ.top() << '\n';
				heapQ.pop();
			}
		}
		else {
			heapQ.push(x);
		}
	}
}