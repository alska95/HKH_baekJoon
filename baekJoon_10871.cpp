#include <iostream>
#define max 10001
using namespace std;

int main() {
	int counter = 0;
	int n, x;
	int arr;
	int arrb[max];

	cin >> n >> x;
	for (int i = 0; i < n; i++) {
		cin >> arr;
		if (arr < x)
			arrb[counter++] = arr;
	}

	for (int i = 0; i < counter; i++) {
		cout << arrb[i] << ' ';
	}
}