#include <iostream>

using namespace std;

int main() {
	string a;
	int testcase;
	cin >> testcase;
	for (int i = 0; i < testcase; i++) {
		int temp = 0;
		int sum = 0;
		cin >> a;
		for (int i = 0; i < a.size(); i++) {
			if (i > 0 && a[i - 1] == 'O' && a[i] == 'O')
				temp++;
			else if (a[i] == 'O')
				temp++;
			else
				temp = 0;
			sum += temp;
		}
		cout << sum << '\n';
	}
}