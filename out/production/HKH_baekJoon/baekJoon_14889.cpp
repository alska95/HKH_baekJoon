#include <iostream>
#include <cmath>

using namespace std;
#define max 20

int squareSize, stats[max][max], visited[max][max]; // 인원수 , 인원들의 능력치 , visited flag
int smallest = 100000000;
int teamFlag = 1;

int min(int a, int b) {
	return (a < b) ? a : b;
}

void displayVisited() {
	for (int i = 0; i < squareSize; i++) {
		for (int j = 0; j < squareSize; j++) {
			cout << visited[i][j];
		}
		cout << '\n';
	}
	cout << '\n';
}



void findClosest(int counter, int flag) {


	if (counter == squareSize / 2) { //한쪽팀이 전부 채워짐 , 다른쪽팀과 비교
		if (flag == 1) {
			findClosest(0, 2);
		}
		else {
			int team1 = 0, team2 = 0;

			for (int i = 0; i < squareSize; i++) {
				for (int j = 0; j < squareSize; j++) {
					if (visited[i][j] == 1)
						team1 += stats[i][j];
					if (visited[i][j] == 2)
						team2 += stats[i][j];
				}
			}
			smallest = min(smallest, abs(team1 - team2)); //능력치 차이의 최소값을 저장
			teamFlag = 1;
			return;
		}

	}

	for (int i = 0; i < squareSize; i++) {
		for (int j = 0; j < squareSize; j++) {
			if (i > j&& visited[i][j] == 0) { // 대각선의 위쪽 성분만 연산
				if (teamFlag == 1) {
					visited[i][j] = visited[j][i] = 1;
					findClosest(counter + 1, 1);
					displayVisited();
					visited[i][j] = visited[j][i] = 0;
				}
				if (teamFlag == 2) {
					visited[i][j] = visited[j][i] = 2;
					findClosest(counter + 1, 2);
					//displayVisited();
					visited[i][j] = visited[j][i] = 0;
				}

			}
		}
	}
}


int main() {


	cin >> squareSize;
	for (int i = 0; i < squareSize; i++) {
		for (int j = 0; j < squareSize; j++) {
			cin >> stats[i][j];
		}
	}

	findClosest(0);

	cout << smallest;
}