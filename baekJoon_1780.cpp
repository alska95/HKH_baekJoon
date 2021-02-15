#include <iostream>
using namespace std;

#define MAX 2200

int nineTree[MAX][MAX];
int mCount, zCount, oCount;

void divideConquer(int y, int x, int size) {
	int zeroFlag = 0, oneFlag = 0, minusFlag = 0;
	for (int i = y; i < y + size; i++) {
		for (int j = x; j < x + size; j++) {
			if (nineTree[i][j] == -1)
				minusFlag = 1;
			else if (nineTree[i][j] == 1)
				oneFlag = 1;
			else if (nineTree[i][j] == 0)
				zeroFlag = 1;
			if (minusFlag == 1 && zeroFlag == 1 && oneFlag == 1)
				break;
		}
	}
	int sum = minusFlag + zeroFlag + oneFlag;
	if (sum > 1) {
		divideConquer(y, x, size / 3);
		divideConquer(y, x + size / 3, size / 3);
		divideConquer(y, x + 2 * size / 3, size / 3);
		divideConquer(y + size / 3, x, size / 3);
		divideConquer(y + 2 * size / 3, x, size / 3);
		divideConquer(y + size / 3, x + size / 3, size / 3);
		divideConquer(y + size / 3, x + 2 * size / 3, size / 3);
		divideConquer(y + 2 * size / 3, x + size / 3, size / 3);
		divideConquer(y + 2 * size / 3, x + 2 * size / 3, size / 3);
	}
	else if (minusFlag == 1 && zeroFlag == 0 && oneFlag == 0) {
		mCount++;
	}
	else if (minusFlag == 0 && zeroFlag == 1 && oneFlag == 0) {
		zCount++;
	}
	else if (minusFlag == 0 && zeroFlag == 0 && oneFlag == 1) {
		oCount++;
	}
}

int main() {
	int size = 0;
	cin >> size;
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			cin >> nineTree[i][j];
		}
	}
	divideConquer(0, 0, size);
	printf("%d\n%d\n%d", mCount, zCount, oCount);
}