#include <iostream>
#include <queue>
#define MAX 20001

using namespace std;

int vertexNum, nodeNum;
int node[MAX][MAX];
int costA[MAX];

struct vertexS {
	int v, cost;
};

queue<vertexS> costQ;

int max(int a, int b) {
	return (a > b) ? a : b;
}

int min(int a, int b) {
	return(a < b) ? a : b;
}

void bfsC(int a) {
	costQ.push({ a, 0 });
	while (!costQ.empty()) {

		int ver = costQ.front().v;
		int cost = costQ.front().cost;
		costQ.pop();

		for (int i = 1; i <= vertexNum; i++) {
			if (node[ver][i] != 0) {
				if (costA[i] == 0 || costA[i] > cost + node[ver][i]) {
					costA[i] = cost + node[ver][i];
					costQ.push({ i, costA[i] });
				}
			}
		}
	}
}

int main() {
	int x, y, cost, start;


	cin >> vertexNum >> nodeNum >> start;

	for (int i = 0; i < vertexNum; i++) {
		cin >> x >> y;
		cin >> cost;
		node[x][y] = max(cost, node[x][y]);
	}

	bfsC(start);
	for (int i = 1; i <= vertexNum; i++) {
		if (i != start && costA[i] == 0) {
			cout << "INF";
		}
		else {
			cout << costA[i] << '\n';
		}
	}
}