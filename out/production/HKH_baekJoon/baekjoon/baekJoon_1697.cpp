#include <iostream>
#include <queue>
#define max 10000000
using namespace std;


int start, target, result;
int counter[max];


queue<int> targetQ;
/*
 + , - , *
 temp�� �ϳ��� ���� ť�� ��������� �Ƿ���?
 +temp =
 */

void findTarget() {
	targetQ.push(start);
	int targetCount = 0;
	counter[start] = 1;

	while (!targetQ.empty()) {
		int tmp = targetQ.front();
		targetQ.pop();
		if (tmp == target) {
			result = counter[target];
			break;
		}
		else {

			if (tmp > target) {
				if (counter[tmp - 1] == 0 && tmp - 1 >= 0) {
					targetQ.push(tmp - 1);
					counter[tmp - 1] = counter[tmp] + 1;
				}
			}
			else {
				if (counter[tmp + 1] == 0) {
					targetQ.push(tmp + 1);
					counter[tmp + 1] = counter[tmp] + 1;
				}
				if (counter[tmp - 1] == 0 && tmp - 1 >= 0) {
					targetQ.push(tmp - 1);
					counter[tmp - 1] = counter[tmp] + 1;
				}
				if (counter[tmp * 2] == 0) {
					targetQ.push(tmp * 2);
					counter[tmp * 2] = counter[tmp] + 1;
				}
			}
		}

	}
}


int main() {
	cin >> start >> target;
	findTarget();
	cout << result - 1;
}