#include <iostream>
using namespace std;
int numGroup[43];
int main() {
	int num;
	int sum = 0;
	for (int i = 0; i < 10; i++) {
		cin >> num;
		numGroup[num % 42] = 1;
	}

	for (int i = 0; i <= 42; i++) {
		sum += numGroup[i];
	}
	cout << sum;
}