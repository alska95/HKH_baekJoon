#include <iostream>
#include <queue>
#include <vector>

#define INF 200000000
#define MAX 30002
using namespace std;

int vertexNum, nodeNum, start;
int dist[MAX]; //�Ÿ������� ó���� �������� �ʱ�ȭ

struct vertexS {
	int v, cost;
};

struct cmp {
	bool operator()(vertexS a, vertexS b) {
		return a.cost > b.cost; //�켱���� �ڽ�Ʈ �������� ���� ������ ������
	}
};

vector<vertexS> vertexV[MAX];
priority_queue<vertexS, vector<vertexS>, cmp> vertexQ; // �켱���� ť�� ��������μ� ���� ���� ����� ��尡 top�� ��ġ�Ѵ�.

void Dijkstra(int start) {
	vertexQ.push({ start , 0 }); //�ʱ��� 0 , ������
	dist[start] = 0;

	while (!vertexQ.empty()) {//���� bfs�� ����
		int cost = vertexQ.top().cost;
		int ver = vertexQ.top().v;
		vertexQ.pop();

		for (int i = 0; i < vertexV[ver].size(); i++) {//ver��° ������ ����� ����� ����ŭ �ݺ�
			int nextV = vertexV[ver][i].v; //���� ���
			int nextC = vertexV[ver][i].cost;//�̵��ϴ� ���

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
