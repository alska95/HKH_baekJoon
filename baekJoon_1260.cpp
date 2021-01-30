#include <iostream>
#include <queue>

using namespace std;
#define MAX 1002

int visited[MAX], node[MAX][MAX];
queue<int> bfsQ;
int start;
int nodeNum, vertexNum;
int x, y;

void init() {
	for (int i = 0; i < MAX; i++) {
		visited[i] = 0;
	}
}

void bfs(int data) {
	cout << data << ' ';
	visited[data] = 1;
	bfsQ.push(data);

	while (!bfsQ.empty()) {
		data = bfsQ.front();
		bfsQ.pop();
		for (int i = 1; i <= vertexNum; i++) {
			if (node[data][i] == 1 && visited[i] != 1) {
				visited[i] = 1;
				cout << i << ' ';
				bfsQ.push(i);
			}
		}
	}
}

void dfs(int data) {
	cout << data << ' ';
	visited[data] = 1;
	for (int i = 1; i <= vertexNum; i++) {
		if (node[data][i] == 1 && visited[i] != 1) {
			dfs(i);
		}
	}
}

int main() {
	cin >> vertexNum >> nodeNum >> start;
	for (int i = 0; i < nodeNum; i++) {
		cin >> x >> y;
		node[x][y] = node[y][x] = 1;
	}

	dfs(start);
	cout << '\n';
	init();
	bfs(start);

	return 0;
}