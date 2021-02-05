#include <iostream>
using namespace std;

int aNumber[10000000];

int main() {
	int counter = 0;
	int target;
	aNumber[1] = 1;
	cin >> target;
	while (1) {
		counter++;
		aNumber[counter] = aNumber[counter - 1] + 6 * counter;
		if (target == aNumber[counter])
			break;
		if (aNumber[counter - 1] < target && target < aNumber[counter]) {
			counter++;
			break;
		}
	}
	cout << counter - 1;
}