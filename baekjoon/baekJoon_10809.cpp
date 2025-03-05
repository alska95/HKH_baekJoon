#include <iostream>

using namespace std;

string a;




int main() {
	cin >> a;

	const int start = 'a';
	const int end = 'z';
	const int total = end - start;

	int arr[total + 1];

	for (int i = 0; i < total + 1; i++) {
		arr[i] = -1;
	}
	for (int i = 0; i < a.size(); i++) {
		if (arr[a[i] - 'a'] == -1)
			arr[a[i] - 'a'] = i;
	}
	for (int i = 0; i < total + 1; i++) {
		cout << arr[i] << ' ';
	}

}