#include <iostream>
using namespace std;

#define MAX 101

int boardSize;
int gameBoard[MAX][MAX];
int visited[MAX][MAX];
int counter;

int dx[2] = { 0 , 1 };
int dy[2] = { 1, 0 };

void DFS(int y, int x) {

	visited[y][x] = 1;

	int index = gameBoard[y][x];

	//printf("visited[%d][%d] index = %d counter = %d\n", y, x, index ,counter);

	for (int i = 0; i < 2; i++) {
		int newY = y + dy[i] * index;
		int newX = x + dx[i] * index;
		if (newX >= boardSize || newY >= boardSize)
			continue;
		if (visited[newY][newX] != 1) {
			DFS(newY, newX);
		}
	}

	if (index == 0)
		counter++;
	visited[y][x] = 0;

}



int main() {
	cin >> boardSize;
	for (int i = 0; i < boardSize; i++) {
		for (int j = 0; j < boardSize; j++) {
			cin >> gameBoard[i][j];
		}
	}


	DFS(0, 0);
	cout << counter;
}