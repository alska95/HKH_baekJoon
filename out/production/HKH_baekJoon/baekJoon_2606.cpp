#include <iostream>
using namespace std;

#define MAX 101

bool visited[MAX], node[MAX][MAX];
int infectedOne = 1, x, y;
int vertexNum, nodeNum;

void DFS(int data) {
	visited[data] = true;
	for (int i = 1; i <= vertexNum; i++) {
		if (visited[i] != true && node[data][i] == true)
			DFS(i);
	}
}


int main() {
	cin >> vertexNum >> nodeNum;

	int result = 0;

	for (int i = 0; i < nodeNum; i++) {
		cin >> x >> y;
		node[x][y] = node[y][x] = true;
	}


	DFS(infectedOne);

	for (int i = 0; i < MAX; i++) {
		if (visited[i] == true) result++;
	}


	cout << result - 1; //infectedOne은 제외됨으로
}