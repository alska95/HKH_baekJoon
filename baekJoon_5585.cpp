#include <iostream>
using namespace std;

int main() {
	int cost;
	cin >> cost;
	int change = 1000 - cost, counter = 0;
	while (change != 0) {
		if (change / 500 != 0) {
			counter += change / 500;
			change %= 500;
		}
		else
			if (change / 100 != 0) {
				counter += change / 100;
				change %= 100;
			}
			else
				if (change / 50 != 0) {
					counter += change / 50;
					change %= 50;
				}
				else
					if (change / 10 != 0) {
						counter += change / 10;
						change %= 10;
					}
					else
						if (change / 5 != 0) {
							counter += change / 5;
							change %= 5;
						}
						else
							if (change / 1 != 0) {
								counter += change / 1;
								change %= 1;
							}
	}
	cout << counter;
}