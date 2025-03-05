#include <iostream>
using namespace std;
#include <queue>

#define MAX 101

int vertexNum, node[MAX][MAX], drawMap[MAX][MAX], visited[MAX];


queue<int> loadQ;


void bfsLoad(int k) { //dfs로는 한큐에 다돌리는 발상을 못했음 ㅜ
	loadQ.push(k);

	while (!loadQ.empty()) {
		int y = loadQ.front();
		loadQ.pop();
		for (int x = 1; x <= vertexNum; x++) {
			if (node[y][x] == 1 && visited[x] == 0) {
				visited[x] = 1;
				loadQ.push(x);
			}
		}
	}

	for (int i = 1; i <= vertexNum; i++) {
		if (visited[i] == 1) {
			drawMap[k][i] = 1;
		}
	}
	for (int i = 1; i <= vertexNum; i++) {
		visited[i] = 0;
	}
}




int main() {
	cin >> vertexNum;
	for (int i = 1; i <= vertexNum; i++) {
		for (int j = 1; j <= vertexNum; j++) {
			cin >> node[i][j];
		}
	}

	for (int i = 1; i <= vertexNum; i++) {
		bfsLoad(i);
	}

	for (int i = 1; i <= vertexNum; i++) {
		for (int j = 1; j <= vertexNum; j++) {
			cout << drawMap[i][j];
			cout << ' ';
		}
		cout << '\n';
	}
}