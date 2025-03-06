#include <iostream>
using namespace std;
#define max 1001

int vertexNum, nodeNum, node[max][max], visited[max];

void dfs(int start) {
	visited[start] = 1;
	for (int i = 1; i <= vertexNum; i++) {
		if (node[start][i] == 1 && !visited[i]) {
			dfs(i);
		}

	}
}

int main() {
	int x, y;
	cin >> vertexNum >> nodeNum;
	for (int i = 0; i < nodeNum; i++) {
		cin >> x >> y;
		node[x][y] = node[y][x] = 1;
	}
	int counter = 0;
	for (int i = 1; i <= vertexNum; i++) {
		if (visited[i] == 0) {
			dfs(i);
			counter++;
		}
	}
	cout << counter;
}