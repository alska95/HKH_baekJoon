/*
�ݴ�� �Ʒ��� ����
1
2 1*2 or 1+1
3 1*3
4 1*2*2
5 1*2*2+1
6 1*2*3
7 6 1
8 4 2
9 3 3
10 9 1
11 9 1 1
12 6*2
13 6*2 +1
14 7 * 2

�� ����arr�� count�� �����س���
arr[n]�� ���
arr[n-1] +1�� ���
arr[n/2] + 1 �� ���
arr[n/3] +1�� ����߿� ����
*/
#include <iostream>
using namespace std;

int arr[1000001];

int min(int a, int b) {
	return (a < b) ? a : b;
}

int main() {
	int vary;
	cin >> vary;

	arr[1] = 0;

	for (int i = 2; i <= vary; i++) {
		arr[i] = arr[i - 1] + 1;
		if (i % 2 == 0) {
			arr[i] = min(arr[i], arr[i / 2] + 1); //���� ���� -1�Ѱ� count�� ū�� �ƴϸ� /2�Ѱ��� +1 count�� ū���Ѱ� 
		}
		if (i % 3 == 0) {
			arr[i] = min(arr[i], arr[i / 3] + 1);
		}
	}


	cout << arr[vary];
}