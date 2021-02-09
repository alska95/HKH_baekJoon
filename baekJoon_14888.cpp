#include <iostream>
#define max 15
using namespace std;

int numberLength, givenArr[max];
int OperatorCounter[4], OCTemp[4]; // +-*/
int biggest = -1000000001, smallest = 1000000001;

int smaller(int a, int b) {
	return (a < b) ? a : b;
}
int bigger(int a, int b) {
	return (a > b) ? a : b;
}


void OperatorDFS(int result, int counter) {

	if (counter == numberLength - 1) {
		smallest = smaller(result, smallest);
		biggest = bigger(result, biggest);
		for (int i = 0; i < 4; i++) {
			OCTemp[i] = 0;
		}
		return;
	}

	if (givenArr[counter + 1] != 0) {
		for (int i = 0; i < 4; i++) {
			if (OperatorCounter[i] > 0) {
				OperatorCounter[i]--;

				if (i == 0) { //+연산자가 남은경우
					OperatorDFS(result + givenArr[counter + 1], counter + 1);

				}
				if (i == 1) {

					OperatorDFS(result - givenArr[counter + 1], counter + 1);

				}
				if (i == 2) {

					OperatorDFS(result * givenArr[counter + 1], counter + 1);

				}
				if (i == 3) {

					OperatorDFS(result / givenArr[counter + 1], counter + 1);

				}
				OperatorCounter[i]++;
			}
		}

	}




}

int main() {
	cin >> numberLength;
	for (int i = 0; i < numberLength; i++) {
		cin >> givenArr[i];
	}
	for (int i = 0; i < 4; i++) {
		cin >> OperatorCounter[i];
	}

	OperatorDFS(givenArr[0], 0);
	printf("%d\n%d", biggest, smallest);
}