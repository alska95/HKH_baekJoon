#include <iostream>
using namespace std;
/*
10보다 작은경우
1의자리 * 10 + 1의 자리를 한다 = n*11;
10보다 큰경우
  (10의 자리 + 1의자리 의 결과값  )+ 1의자리
		if( 10보다 크면 1의자리만 사용)
*/
int main() {
	int countN = 1, n;
	cin >> n;
	int tmp, tmp2;

	if (n < 10)
		tmp = n * 11;
	else {
		tmp2 = n / 10 + n % 10;
		if (tmp2 >= 10)
			tmp2 = tmp2 % 10;
		tmp = tmp2 + ((n % 10) * 10);
	}
	while (tmp != n) {
		if (tmp < 10)
			tmp = tmp * 11;
		else {
			tmp2 = tmp / 10 + tmp % 10;
			if (tmp2 >= 10)
				tmp2 = tmp2 % 10;
			tmp = tmp2 + (tmp % 10) * 10;
		}
		countN++;
	}

	cout << countN;
}
