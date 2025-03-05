#include <iostream>
using namespace std;

/*
1. �迭�� ũ�� n�� �ش��ϴ� ���� ��ġ�� n��° ��ġ�� ��ȯ�Ѵ�.
2. n-1�� ��ġ�� n-1��° rotate


������ �޾ƿ��� �����ŭ �迭�� �Է¹޴´�.
*/

int sz;
int cnt = 0;
int arr[500];
int compArr[500];

struct rotateSt {
	int a;
	int b;
};


void rotate(int a, int b, rotateSt c[]) {
	c[cnt].a = a + 1;
	c[cnt].b = b + 1;
	int j = a;
	int tmp[250];
	for (int i = a; i <= b; i++) {
		tmp[i] = compArr[i]; //a~b����
	}
	for (int i = b; i >= a; i--) {

		compArr[i] = -tmp[j++];
	}
	cnt++;
}
/*
void display(int arr[]) {
	for (int i = 0; i < sz; i++) {
		cout << arr[i] << ' ';
	}
	cout << '\n';
}
*/

void solve(rotateSt a[]) {
	for (int i = sz - 1; i >= 0; i--) {
		int key = i + 1;//Ű�� i-1��° �ڸ��� �ö����� rotate�ؾ��Ѵ�.
		if (compArr[i] == -key) {
			rotate(i, i, a);
		}
		else if (compArr[i] != key) { //���� ū �ڸ��� ���� ū ���ڰ� ������
			int j = 0;
			while (1) {
				if (key == compArr[j]) {
					rotate(j, i, a);
					rotate(i, i, a);
					//		display(compArr);
					break;
				}
				else if (-key == compArr[j]) {
					rotate(j, i, a);
					//		display(compArr);
					break;
				}
				j++;
			}

		}

	}
}

int main() {

	rotateSt a[500];

	int tmp;
	cin >> sz;

	for (int i = 0; i < sz; i++) {
		arr[i] = i + 1;
	}

	for (int i = 0; i < sz; i++) {
		cin >> tmp;
		compArr[i] = tmp;
	}

	//display(compArr);
	solve(a);
	//display(compArr);
	cout << cnt << '\n';
	for (int i = cnt - 1; i >= 0; i--) {
		cout << a[i].a << ' ' << a[i].b << '\n';
	}
}