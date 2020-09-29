#include <iostream>

using namespace std;

void selectsort(int a[], int n) {
	int least;
	int tmp;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		a[i] = tmp;
	}
	for (int i = 0; i < n - 1; i++) {
		least = i;
		for (int j = i + 1; j < n; j++) {
			if (a[least] > a[j]) {
				least = j;
			}
		}
		tmp = a[i];
		a[i] = a[least];
		a[least] = tmp;
	}
	for (int i = 0; i < n; i++) {
		cout << a[i] << '\n';
	}
}
int main() {
	int a[10000];
	int n;
	cin >> n;

	selectsort(a, n);
}