#include <iostream>
using namespace std;

//1904번 00 ,1의 조합으로 얼마나 많은 조합을 만들 수 있는가? 00은 2개로 취급된다.
/*
1 : 1
2 : 00 , 11
3 : 100 , 001 , 111 //0은 짝수만큼만 들어갈 수 있다.
4 : 1001,1100,0011,0000,1111


n번째는 n-1에 1을 추가해서 만드는 경우의 수 + n-2에 00을 추가해서 만드는 경우의 수이다.

2의경우 0000 1100 0011추가
3의경우 1100 ,1001 ,1001 ,0011 ,1111

중복을 제거하기위해 00의 추가는 앞에만 , 1의추가는 뒤에만하기로 정한다.
d[i] = d[i-1] + d[i-2];
*/
int solve(int n) {
	int* arr = new int[n + 1];
	for (int i = 0; i < n + 1; i++) {
		if (i < 3) {
			arr[i] = i;
		}
		else {
			arr[i] = arr[i - 1] + arr[i - 2];
			arr[i] %= 15746;
		}
	}
	return arr[n];
}

int main() {
	int n;
	cin >> n;
	cout << solve(n);
}