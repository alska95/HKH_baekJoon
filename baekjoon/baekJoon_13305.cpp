#include <iostream>
using namespace std;

/*
n���� ���� ������ �������
�⸧�� �־����
Ű�δ� 1����

���ô� �⸧ ������ �ٸ�.

�� ������ �⸧����

solution ���κ��ʺ��� ����� ���ÿ��� �ִ��� ���̻��.

*/
long long cityNum;

long long cityLength[100002] = { 0, }; //i�� i+1������ �Ÿ��� ��Ÿ����.
long long cityValue[100002] = { 0 , };
long long smallest = 0;
long long result = 0;

int main() {


	cin >> cityNum;

	for (int i = 1; i < cityNum; i++) {
		cin >> cityLength[i];
	}

	for (int i = 1; i <= cityNum; i++) {
		cin >> cityValue[i];
	}

	smallest = cityValue[1];

	for (int i = 1; i < cityNum; i++) {
		if (cityValue[i] < smallest) {
			smallest = cityValue[i];
		}
		result += smallest * cityLength[i];

	}

	cout << result;
}