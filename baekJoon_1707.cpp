#include <iostream>
#include <vector>
#define max 20002
using namespace std;

vector<int> nodeV[max];
int vertexNum, nodeNum, color[max];

void initialize() {
	for (int i = 0; i <= vertexNum; i++) {
		for (int j = 0; j < nodeV[i].size(); j++) {
			nodeV[i][j] = 0;
		}
	}
	for (int i = 0; i <= vertexNum; i++) {
		color[i] = 0;
	}
}
void dfs(int pre) {
	if (pre == 1)
		color[pre] = 1;

	for (int i = 0; i < nodeV[pre].size(); i++) {
		int next = nodeV[pre][i];
		if (color[next] == 0) {

			if (color[pre] == 1)
				color[next] = 2;
			else
				color[next] = 1;
			dfs(next);
		}
	}
}
void checkGraph() {
	for (int i = 1; i <= vertexNum; i++) {
		for (int j = 0; j < nodeV[i].size(); j++) {
			int next = nodeV[i][j];
			//cout << color[next] << color[i];
			if (color[next] == color[i]) {

				cout << "NO\n";
				return;
			}
		}
	}
	cout << "YES\n";
}

int main() {
	int testCase;
	int x, y;
	cin >> testCase;
	for (int i = 0; i < testCase; i++) {
		cin >> vertexNum >> nodeNum;
		for (int i = 0; i < nodeNum; i++) {
			cin >> x >> y;
			nodeV[x].push_back(y);
			nodeV[y].push_back(x);

		}
		dfs(1);
		checkGraph();
		initialize();
	}


}