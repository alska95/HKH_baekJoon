#include <iostream>
#include <queue>
#include <vector>
#define MAX 801
#define INF 2147000000
using namespace std;

int vertexNum, nodeNum;
int mustCrossV[2];
int dist[MAX];

struct shortS {
	int start, cost;
};

vector<shortS> shortV[MAX];

struct cmp {
	bool operator()(shortS a, shortS b) {
		return a.cost > b.cost;
	}
};

priority_queue<shortS, vector<shortS>, cmp> shortQ;
int min(int a, int b) {
	return (a < b) ? a : b;
}
void init() {
	for (int i = 0; i < MAX; i++) {
		dist[i] = INF;
	}
}

void dijkstraCut(int i, int j) {
	init();
	dist[i] = j;
	shortQ.push({ i , j }); //start , cost
	while (!shortQ.empty()) {
		int target = shortQ.top().start;
		int cost = shortQ.top().cost;
		shortQ.pop();

		for (int i = 0; i < shortV[target].size(); i++) {
			int newTarget = shortV[target][i].start;
			int newCost = shortV[target][i].cost;
			if (dist[newTarget] > dist[target] + newCost) {
				dist[newTarget] = dist[target] + newCost;
				shortQ.push({ newTarget, dist[newTarget] });
			}
		}
	}
}


int findBest() {
	dijkstraCut(1, 0);
	dijkstraCut(mustCrossV[0], dist[mustCrossV[0]]);
	dijkstraCut(mustCrossV[1], dist[mustCrossV[1]]);
	int firstTry = dist[vertexNum];
	dijkstraCut(1, 0);
	dijkstraCut(mustCrossV[1], dist[mustCrossV[1]]);
	dijkstraCut(mustCrossV[0], dist[mustCrossV[0]]);
	int secondTry = dist[vertexNum];

	return min(firstTry, secondTry);
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int x, y, cost;
	cin >> vertexNum >> nodeNum;
	for (int i = 0; i < nodeNum; i++) {
		cin >> x >> y >> cost;
		shortV[x].push_back({ y , cost });
		shortV[y].push_back({ x , cost });
	}
	cin >> mustCrossV[0] >> mustCrossV[1];

	int result = findBest();
	if (result == INF)
		cout << -1;
	else
		cout << result;
}