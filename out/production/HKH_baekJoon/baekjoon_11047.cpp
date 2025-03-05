#include <iostream>
using namespace std;

int main() {
	int variationNum, totalValue;
	int variation[11] = { 0, };
	int totalNum = 0;

	cin >> variationNum >> totalValue;

	for (int i = 1; i <= variationNum; i++) {
		cin >> variation[i];
	}

	for (int i = variationNum; i > 0; i--) {
		totalNum += totalValue / variation[i];
		totalValue %= variation[i];
	}

	cout << totalNum;
}