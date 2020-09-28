#include <iostream>

using namespace std;


int factorial(int input) {
	if (input == 0)
		return 1;
	else
		return input * factorial(input - 1);
}


int main() {
	int input;
	int result;
	cin >> input;
	cout << factorial(input);

}