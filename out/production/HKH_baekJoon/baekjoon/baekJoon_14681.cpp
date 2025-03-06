#include <iostream>
using namespace std;

int main() {
	int x, y;
	cin >> x >> y;
	if (x < 0) {
		if (y < 0) cout << 3;
		if (y > 0) cout << 2;
	}
	else {
		if (y < 0) cout << 4;
		if (y > 0) cout << 1;
	}
}