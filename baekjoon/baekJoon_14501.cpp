#include <iostream>

#define MAX 16

using namespace std;

int givenDays;
int daySpent[MAX], dayEarned[MAX];
int totalEarnedDp[MAX];
int visited[MAX];

int max(int a, int b) {
	return (a > b) ? a : b;
}

void maxProfit() {
	for (int i = 1; i <= givenDays; i++) {
		if (totalEarnedDp[i] == 0) //��ϵ� ������ �� ���ٸ� ������ ���Ͱ� ����.
			totalEarnedDp[i] = totalEarnedDp[i - 1];
		for (int j = 1; j <= i; j++) {

			if (daySpent[j] - 1 + j == i) //j�� ���� j�Ͽ� ���� ������ i�� ���� ������ �� �ִٸ�
				totalEarnedDp[i] = max(totalEarnedDp[i], totalEarnedDp[j - 1] + dayEarned[j]);
		}

	}
}

int main() {
	cin >> givenDays;
	for (int i = 1; i <= givenDays; i++) {
		cin >> daySpent[i] >> dayEarned[i];
	}

	maxProfit();

	cout << totalEarnedDp[givenDays];

}