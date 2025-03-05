#include <iostream>
using namespace std;

int main() {
	int A, B, C;

	cin >> A >> B >> C;
	try {
		cout << (A + B) % C << '\n';
		cout << ((A % C) + (B % C)) % C << '\n';
		cout << (A * B) % C << '\n';
		cout << ((A % C) * (B % C)) % C << '\n';
	}
	catch (exception e) {
		cout << 0;
	}


}