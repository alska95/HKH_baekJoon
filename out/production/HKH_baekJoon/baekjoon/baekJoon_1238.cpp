#include <queue>
#include <iostream>
#include <vector>

using namespace std;

#define MAX 1010
#define INF 214000000

int studentNum, nodeNum, target, shortestCut[MAX];
int dist[MAX];

struct farS {
	int cost, y;
};

struct cmp {
	bool operator()(farS a, farS b) {
		return a.cost > b.cost;
	}
};

priority_queue<farS, vector<farS>, cmp> farQ;
vector<farS> farV[MAX];

void init() {
	for (int i = 1; i <= studentNum; i++) {
		dist[i] = INF;
	}
}

int farDijkstra(int start) { //flag 0일때 파티가는길 ,else일때flag로 가는길
	init();

	dist[start] = 0;
	farQ.push({ 0 , start });

	while (!farQ.empty()) {
		int cost = farQ.top().cost;
		int ver = farQ.top().y;
		farQ.pop();

		for (int i = 0; i < farV[ver].size(); i++) {
			int nextC = cost + farV[ver][i].cost;
			int nextV = farV[ver][i].y;

			if (dist[nextV] > nextC + cost) {
				dist[nextV] = nextC + cost;
				farQ.push({ dist[nextV] ,nextV });
			}
		}
	}
	return dist[target];
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> studentNum >> nodeNum >> target;

	int x, y, cost;
	for (int i = 0; i < nodeNum; i++) {
		cin >> x >> y >> cost;
		farV[x].push_back({ cost, y });
	}

	for (int i = 1; i <= studentNum; i++) {
		shortestCut[i] = farDijkstra(i);
		cout << shortestCut[i];
	}
	farDijkstra(target);
	for (int i = 1; i <= studentNum; i++) {
		shortestCut[i] += dist[i];
	}


	int longest = 0;

	for (int i = 1; i <= studentNum; i++) {
		cout << shortestCut[i] << '\n';
	}
	for (int i = 1; i <= studentNum; i++) {
		if (shortestCut[i] > longest)
			longest = shortestCut[i];
	}

	cout << longest;
}