/*
���� �� ������� �κ� ����
��������
��������
or Ư�� ���� �������� , �������� ���ĵ� ����

������ ������ ������.

i�� s(�߽����� ��´�)

�ϴ� �迭 ó������ ������ �������� ��� �����ϴ�
dpUp[]
�����������
dpDown[]

������� ���
dpBi[count] = dpUp[]+dpDown[] -1(�ڱ��ڽ�)

for(int i = 0 ~
result = dpBi[max]
*/

#include <iostream>
using namespace std;



int main() {
	int count;
	int arr[1000]; //input��
	int upDp[1000]; //�������� ���� �����迭
	int downDp[1000]; //�������� ����
	int biDp[1000]; //������� 

	int biggest = 0;

	cin >> count;
	for (int i = 0; i < count; i++) {
		cin >> arr[i];
	}


	for (int i = 0; i < count; i++) {
		upDp[i] = 1;
		downDp[count - i - 1] = 1;
		for (int j = 0; j < i; j++) {
			if (arr[i] > arr[j] && upDp[j] + 1 > upDp[i]) upDp[i] = upDp[j] + 1;
		} //�������� �� ����
	}

	for (int i = count - 1; i >= 0; i--) {
		downDp[i] = 1;
		for (int j = count - 1; j > i; j--) {
			if (arr[i] > arr[j] && downDp[j] + 1 > downDp[i]) downDp[i] = downDp[j] + 1;
		}	//�������� �� ����
	}
	for (int i = 0; i < count; i++) {
		biDp[i] = upDp[i] + downDp[i] - 1;
		if (biDp[i] > biggest)
			biggest = biDp[i];
	}

	cout << biggest;

}