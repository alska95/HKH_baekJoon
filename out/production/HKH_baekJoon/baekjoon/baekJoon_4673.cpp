#include <iostream>
using namespace std;

int selfArr[10001];

void selfNum() {
	for (int N = 1; N <= 10000; N++) {
		int tmp = N;
		int result = N;
		while (tmp != 0) {
			result += tmp % 10;
			tmp /= 10;
		}
		selfArr[result] = 1;
	}

	for (int i = 1; i <= 10000; i++) {
		if (selfArr[i] == 0)
			cout << i << '\n';
	}
}
int main() {
	selfNum();
}