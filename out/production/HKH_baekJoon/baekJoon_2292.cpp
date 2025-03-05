#include <iostream>
using namespace std;

int main() {
	int target;
	cin >> target;

	int i = 1;
	int j = 1;
	while (1) {
		if (j >= target)
			break;
		j += 6 * i++;

	}
	cout << i;
}