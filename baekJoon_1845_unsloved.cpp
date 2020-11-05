#include <iostream>
using namespace std;

/*
1. 배열의 크기 n에 해당하는 수의 위치와 n번째 위치를 교환한다.
2. n-1의 위치와 n-1번째 rotate


사이즈 받아오고 사이즈만큼 배열을 입력받는다.
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
		tmp[i] = compArr[i]; //a~b저장
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
		int key = i + 1;//키가 i-1번째 자리에 올때까지 rotate해야한다.
		if (compArr[i] == -key) {
			rotate(i, i, a);
		}
		else if (compArr[i] != key) { //가장 큰 자리에 가장 큰 숫자가 없으면
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