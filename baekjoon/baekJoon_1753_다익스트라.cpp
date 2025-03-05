#include <iostream>
#include <queue>
#include <vector>

#define INF 200000000
#define MAX 30002
using namespace std;

int vertexNum, nodeNum, start;
int dist[MAX]; //거리값저장 처음에 무한으로 초기화

struct vertexS {
	int v, cost;
};

struct cmp {
	bool operator()(vertexS a, vertexS b) {
		return a.cost > b.cost; //우선순위 코스트 낮은것이 가장 앞으로 오게함
	}
};

vector<vertexS> vertexV[MAX];
priority_queue<vertexS, vector<vertexS>, cmp> vertexQ; // 우선순위 큐를 사용함으로서 가장 낮은 비용의 노드가 top에 위치한다.

void Dijkstra(int start) {
	vertexQ.push({ start , 0 }); //초기비용 0 , 시작점
	dist[start] = 0;

	while (!vertexQ.empty()) {//이후 bfs와 유사
		int cost = vertexQ.top().cost;
		int ver = vertexQ.top().v;
		vertexQ.pop();

		for (int i = 0; i < vertexV[ver].size(); i++) {//ver번째 정점과 연결된 노드의 수만큼 반복
			int nextV = vertexV[ver][i].v; //다음 노드
			int nextC = vertexV[ver][i].cost;//이동하는 비용

			if (dist[nextV] > cost + nextC)
			{
				dist[nextV] = cost + nextC;
				vertexQ.push({ nextV, dist[nextV] });
			}
		}
	}

}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int x, y, cost, start;


	cin >> vertexNum >> nodeNum >> start;

	for (int i = 0; i < nodeNum; i++) {
		cin >> x >> y;
		cin >> cost;
		vertexV[x].push_back({ y ,cost });
	}

	for (int i = 1; i <= vertexNum; i++) {
		dist[i] = INF;
	}

	Dijkstra(start);

	for (int i = 1; i <= vertexNum; i++) {
		if (dist[i] == INF) cout << "INF\n";
		else cout << dist[i] << '\n';
	}

}
