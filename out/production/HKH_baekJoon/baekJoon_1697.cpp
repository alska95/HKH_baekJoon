#include <iostream>
#include <queue>
#define max 10000000
using namespace std;


int start, target, result;
int counter[max];


queue<int> targetQ;
/*
 + , - , *
 temp로 하나씩 놓고 큐에 집어넣으면 되려나?
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