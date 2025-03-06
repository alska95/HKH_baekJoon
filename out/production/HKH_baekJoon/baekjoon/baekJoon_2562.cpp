#include <iostream>
using namespace std;

int max(int a, int b) {
	return (a > b) ? a : b;
}

int main() {
	int n;
	int biggest = 0;
	int counter = 0;
	for (int i = 0; i < 9; i++) {
		cin >> n;
		if (biggest < n) {
			biggest = n;
			counter = i;
		}
	}
	cout << biggest << '\n' << counter+1;
}