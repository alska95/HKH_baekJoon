#include <iostream>
#include <stack>
using namespace std;

stack<int> fault;

int main() {
	int k;
	int tmp;
	cin >> k;
	for (int i = 0; i < k; i++) {
		cin >> tmp;
		if (tmp == 0)
			fault.pop();
		else
			fault.push(tmp);
	}
	int sum = 0;
	while (!fault.empty()) {
		sum += fault.top();
		fault.pop();
	}
	cout << sum;
}