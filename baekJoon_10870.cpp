#include <iostream>

using namespace std;

int fibonacci(int input) {
	if (input < 2)
		return input;
	else
		return fibonacci(input - 1) + fibonacci(input - 2);
}

int main() {
	int input;
	cin >> input;
	cout << fibonacci(input);
}