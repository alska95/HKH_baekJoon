#include <iostream>
using namespace std;
//�迭 10 ���� %10 �ϸ鼭 ����� �迭 �ε������� ++
int main() {
	int a, b, c;
	int result = 0;
	int indicateArr[10] = { 0 , };
	cin >> a >> b >> c;
	result = a * b * c;
	while (result != 0) {
		indicateArr[result % 10]++;
		result /= 10;
	}
	for (int i = 0; i < 10; i++) {
		cout << indicateArr[i] << '\n';
	}
}