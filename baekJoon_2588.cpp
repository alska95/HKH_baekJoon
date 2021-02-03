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
			for (int j = 0; j < xNum; j++) { //��� 1�� Ž��
//////////////////////////////////////////////////////////

				if(tomatoFarm[i][j] == '1' && !visitedDay[i][j])
					for (int k = 0; k < 4; k++) { //4���� ����
						int newX = x + dx[k]; //�̵��� ��� x , y
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
		/////////////////////�������� �ʱ�ȭ
		dayCount++;

		////////////////////��������üũ
		for (int i = 0; i < yNum; i++) {
			for (int j = 0; j < xNum; j++) {
				if (tomatoFarm[i][j] == '0') {
					int check = 0;
					zeroFlag = true;//��� ĭ�� 0�� �������
					for (int k = 0; k < 4; k++) { //4���� ���� -1�� �ѷ����̸� surroundFlag true
						int newX = i + dx[k]; //�̵��� ��� x , y
						int newY = j + dy[k];

						int temp[4] = { 0 , }; //4���� Ȯ��

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