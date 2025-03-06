#include <iostream>
using namespace std;
int numGroup[1001];
int main() {
	int N;
	int grade[1001];
	double sum = 0;
	int biggest = 0;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> grade[i];
		if (grade[i] > biggest)
			biggest = grade[i];
	}
	for (int i = 0; i < N; i++)
		sum += (double)grade[i] / (double)biggest * 100;
	cout.setf(ios::fixed);
	cout.precision(1);
	cout << sum / N;
}