#include <iostream>
#include <cmath>
using namespace std;



int main() {
	int testCase;
	cin >> testCase;
	for (int i = 0; i < testCase; i++) {
		int studentNum;
		cin >> studentNum;
		int score[1001];
		int sum = 0;
		for (int i = 0; i < studentNum; i++) {
			cin >> score[i];
			sum += score[i];
		}
		double avg = 0;
		avg = sum / (double)studentNum;
		int counter = 0;
		for (int i = 0; i < studentNum; i++) {
			if (score[i] > avg)
				counter++;
		}
		double avgUp = 0;
		avgUp = counter / (double)studentNum;

		avgUp = round(avgUp * 100000) / 100000;

		cout.setf(ios::fixed);
		cout.precision(3);
		cout << avgUp * 100 << "%\n";
	}

}