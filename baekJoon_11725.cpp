#include <iostream>
#include <queue>
#include <vector>

using namespace std;

#define max 100010

int nodeNum, parent[max], visited[max];
vector<int> node[max];
queue<int> treeQ;


void treeBfs() {
	treeQ.push(1);
	visited[1] = 1;
	while (!treeQ.empty()) {
		int start = treeQ.front();
		treeQ.pop();
		for (int i = 0; i < node[start].size(); i++) {
			int next = node[start][i];
			if (visited[next] == 0) {
				visited[next] = 1;
				parent[next] = start;
				treeQ.push(next);
			}
		}
	}
}



int main() {

	cin >> nodeNum;

	int x, y;

	for (int i = 1; i < nodeNum; i++) {
		cin >> x >> y;
		node[x].push_back(y);
		node[y].push_back(x);
	}
	treeBfs();

	for (int i = 2; i <= nodeNum; i++) {
		cout << parent[i] << '\n';
	}
}