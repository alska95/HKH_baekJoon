#include <iostream>
using namespace std;
/*
10���� �������
1���ڸ� * 10 + 1�� �ڸ��� �Ѵ� = n*11;
10���� ū���
  (10�� �ڸ� + 1���ڸ� �� �����  )+ 1���ڸ�
		if( 10���� ũ�� 1���ڸ��� ���)
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
