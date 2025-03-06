/*
반대로 아래서 위로
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

각 숫자arr에 count값 저장해놓고
arr[n]의 경우
arr[n-1] +1의 방법
arr[n/2] + 1 의 방법
arr[n/3] +1의 방법중에 택일
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
			arr[i] = min(arr[i], arr[i / 2] + 1); //이전 숫자 -1한게 count가 큰지 아니면 /2한값에 +1 count가 큰지한게 
		}
		if (i % 3 == 0) {
			arr[i] = min(arr[i], arr[i / 3] + 1);
		}
	}


	cout << arr[vary];
}