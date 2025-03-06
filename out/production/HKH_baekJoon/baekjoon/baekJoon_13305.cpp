#include <iostream>
using namespace std;

/*
n개의 도시 일직선 수평방향
기름을 넣어야함
키로당 1리터

도시당 기름 가격이 다름.

각 도시의 기름가격

solution 끝부분쪽부터 가장싼 도시에서 최대한 많이산다.

*/
long long cityNum;

long long cityLength[100002] = { 0, }; //i와 i+1도시의 거리를 나타낸다.
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