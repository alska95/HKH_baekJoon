/*
직각삼각형 구별법
에이 제곱 플러스 비 제곱은 씨

가장 큰것을 씨로 둔다.
나머지 두개를 제곱한다.
*/

#include <iostream>

using namespace std;

void quicksort(int L, int R, int a[]) {
	int left = L, right = R, pivot = a[(L + R) / 2];
	if (L >= R) return;
	while (left <= right) {
		while (a[left] < pivot) left++;
		while (a[right] > pivot) right--;
		if (left <= right) {
			swap(a[left], a[right]);
			left++;
			right--:
		}
	}

	quicksort(left, R, a);
	quicksort(L, right, a);
}

int main() {
	int input[3] = { 1,1,1 };

	do{
		for (int i = 0; i < 3; i++) {
			cin >> input[i];
		}

		quicksort(0, 2, input);

		if (input[0] * input[0] + input[1] * input[1] == input[2] * input[2])
			cout << "right";
		else
			cout << "wrong";
	} while (input[0] == 0 && input[1] == 0 && input[2] == 0)
}