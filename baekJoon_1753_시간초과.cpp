#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int vertexNum, nodeNum;
int costA[20001];

struct vertexS {
	int v, cost;
};

struct nodeCost {
	vector<int> target[2]; // 0은 좌표 / 1은 코스트
};

nodeCost nodeV[20001];

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

		for (int j = 0; j < nodeV[ver].target[0].size(); j++) {
			int nextV = nodeV[ver].target[0][j];
			int nextC = cost + nodeV[ver].target[1][j];

			if (costA[nextV] == 0 || costA[nextV] > cost + nodeV[ver].target[1][j]) {
				costA[nextV] = nextC;
				costQ.push({ nextV, nextC });
			}
		}
	}
}


int main() {
	int x, y, cost, start;
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> vertexNum >> nodeNum >> start;

	for (int i = 0; i < nodeNum; i++) {
		cin >> x >> y;
		cin >> cost;
		nodeV[x].target[0].push_back(y);
		nodeV[x].target[1].push_back(cost);
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