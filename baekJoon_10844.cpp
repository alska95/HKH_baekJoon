/*
1의자리 9
123456789

0과 9를 제외한 나머지
일반항 총 8개

초기값 arr[1][ 1 ~ 9] = 1;
		arr[1][0] = 0;
끝숫자가 i일 경우 1 ~ 8
arr[n][i] = arr[n-1][i+1] + arr[n-1][i-1]

0일경우 arr[n][i] = arr[n-1][i+1]
9일경우 arr[n][i] = arr[n-1][i-1]
*/

#include <iostream>
using namespace std;

int main() {
	int count;
	long result = 0;
	long arr[101][11];

	cin >> count;

	arr[0][0] = 0;
	for (int i = 1; i < 10; i++) {
		arr[0][i] = 1;
	}
	for (int i = 1; i < count; i++) {
		arr[i][0] = arr[i - 1][1] % 1000000000;
		arr[i][9] = arr[i - 1][8] % 1000000000;
		for (int j = 1; j < 9; j++) {
			arr[i][j] = arr[i - 1][j - 1] % 1000000000 + arr[i - 1][j + 1] % 1000000000;
		}
	}

	for (int i = 0; i < 10; i++) {
		result += arr[count - 1][i] % 1000000000;
	}

	cout << result % 1000000000;
}