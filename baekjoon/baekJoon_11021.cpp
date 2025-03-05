#include <iostream>
using namespace std;

int main() {
	int testCase;
	int a, b;
	cin >> testCase;
	for (int i = 1; i <= testCase; i++) {
		cin >> a >> b;
		printf("Case #%d: %d\n", i, a + b);
	}
}