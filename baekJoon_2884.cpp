#include <iostream>
using namespace std;


void getTime(int h, int m) {
	if (m > 59) {
		m -= 60;
		h++;
	}
	if (m < 0) {
		m += 60;
		h--;
	}
	if (h > 23)
		h -= 24;
	if (h < 0)
		h += 24;

	cout << h << ' ' << m;
}


int main() {
	int h, m;

	cin >> h >> m;
	getTime(h, m - 45);

}