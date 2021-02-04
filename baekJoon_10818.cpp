#include <iostream>
using namespace std;

int main() {
	int n;
	int integers;
	int min = 2000000, max = -2000000;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> integers;
		if (integers > max)
			max = integers;
		if (integers < min)
			min = integers;
	}

	cout << min << ' ' << max;
}