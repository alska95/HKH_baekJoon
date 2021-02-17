#include <iostream>

using namespace std;


int main() {
	int N;
	string a;
	cin >> N;
	cin >> a;
	int result = 0;
	for (int i = 0; i < N; i++) {
		result += a[i] - '0';
	}
	cout << result;
}