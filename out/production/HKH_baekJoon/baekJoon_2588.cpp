#include <iostream>
#include <queue>
#include <utility>
#define max 1001

using namespace std;

int xNum, yNum  , dayCount;
string tomatoFarm[max];
bool visitedDay[max][max], stopCount = true , zeroFlag , surroundFlag;

int dx[4] = { 0 , 0 , 1 , -1 };
int dy[4] = { 1, -1 , 0 , 0 };


void ripeTomato() {
	while (stopCount) {

		for (int i = 0; i < yNum; i++) {
			for (int j = 0; j < xNum; j++) { //모든 1을 탐색
//////////////////////////////////////////////////////////

				if(tomatoFarm[i][j] == '1' && !visitedDay[i][j])
					for (int k = 0; k < 4; k++) { //4방향 연산
						int newX = x + dx[k]; //이동한 경로 x , y
						int newY = y + dy[k];
						if (newX < 0 || newY < 0 || newX >= xNum || newY >= yNum)
							continue;
						if (tomatoFarm[newY][newX] == '0') {
							tomatoFarm[newY][newX] = '1';
							visitedDay[newY][newX] = true;
						}					
					}

///////////////////////////////////////////////////////////
			}
		}
		/////////////////////다음날로 초기화
		dayCount++;

		////////////////////속행조건체크
		for (int i = 0; i < yNum; i++) {
			for (int j = 0; j < xNum; j++) {
				if (tomatoFarm[i][j] == '0') {
					int check = 0;
					zeroFlag = true;//모든 칸에 0이 없을경우
					for (int k = 0; k < 4; k++) { //4방향 연산 -1로 둘러쌓이면 surroundFlag true
						int newX = i + dx[k]; //이동한 경로 x , y
						int newY = j + dy[k];

						int temp[4] = { 0 , }; //4방향 확인

						if (newX < 0 || newY < 0 || newX >= xNum || newY >= yNum)
							temp[k] = 1;
						if (tomatoFarm[newY][newX] == '-1')
							temp[k] = 1;
						for (int z = 0; z < 4; z++) {
							check += temp[k];
						}
						if (check == 4) {
							surroundFlag = true;
							break;
						}
							
				}

			}
		}
		if (zeroFlag == false || surrondFlag == true)
			stopCount = false;

		if (stopCount == false)
			break;

		zeroFlag = true;
	}
}


int main() {
	int x, y;

	cin >> xNum >> yNum;

	for (int i = 0; i < yNum; i++) {
		cin >> tomatoFarm[i];
	}

	cout << dayCount;
}