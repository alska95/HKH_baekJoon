#include <iostream>
#include <string>
using namespace std;

int main() {
	string a, b;
	cin >> a >> b;

	cout << stoi(a) * (b[2] - '0') << '\n' << stoi(a) * (b[1] - '0') << '\n' << stoi(a) * (b[0] - '0') << '\n' << stoi(a) * stoi(b);

}