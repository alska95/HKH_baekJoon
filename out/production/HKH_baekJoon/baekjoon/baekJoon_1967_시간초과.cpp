#include <iostream>
#include <vector>
#include <queue>

#define MAX 10010
#define INF 2140000000

using namespace std;
int nodeNum;
int mostDiameter[MAX];
int dist[MAX];

void init() {
	for (int i = 0; i <= nodeNum; i++) {
		dist[i] = INF;
	}
}

struct treeS {
	int node, cost;
};

struct cmp {
	bool operator()(treeS a, treeS b) {
		return a.cost > b.cost;
	}
};

vector<treeS> treeV[MAX];
priority_queue<treeS, vector<treeS>, cmp> treeQ;


int dijkstra(int start, int cost) {
	init();

	dist[start] = cost;
	treeQ.push({ start , cost });

	while (!treeQ.empty()) {
		int cost = treeQ.top().cost;
		int node = treeQ.top().node;
		treeQ.pop();
		for (int i = 0; i < treeV[node].size(); i++) {
			int nextV = treeV[node][i].node;
			int nextC = treeV[node][i].cost;
			if (dist[nextV] > cost + nextC) {
				dist[nextV] = cost + nextC;
				treeQ.push({ nextV , dist[nextV] });
			}
		}
	}
	int most = 0;
	for (int i = 1; i <= nodeNum; i++) {
		if (most < dist[i] && dist[i] != INF) {
			most = dist[i];
		}
	}
	return most;
}

void treeDijkstra(int start) {

	int mostF = 0;
	int mostS = 0;

	int size = treeV[start].size();
	if (size == 0) {
	}
	else if (size == 1) {
		mostS = dijkstra(treeV[start][0].node, treeV[start][0].cost);
	}
	else {
		mostF = dijkstra(treeV[start][0].node, treeV[start][0].cost);
		mostS = dijkstra(treeV[start][1].node, treeV[start][1].cost);
	}

	mostDiameter[start] = mostF + mostS;


}


int main() {
	cin >> nodeNum;
	int x, y, cost;
	for (int i = 0; i < nodeNum - 1; i++) {
		cin >> x >> y >> cost;
		treeV[x].push_back({ y , cost });
	}

	for (int i = 1; i <= nodeNum; i++) {
		treeDijkstra(i);
	}
	int most = 0;
	for (int i = 1; i <= nodeNum; i++) {
		if (most < mostDiameter[i])
			most = mostDiameter[i];
	}
	cout << most;
}