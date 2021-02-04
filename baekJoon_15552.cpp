#include <iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	int testCase;
	cin >> testCase;

	int a, b;
	for (int i = 0; i < testCase; i++) {
		cin >> a >> b;
		cout << a + b << '\n';
	}

}