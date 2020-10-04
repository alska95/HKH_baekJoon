#include<cstdio>
#include<algorithm>
using namespace std;

int n, m;
int result[10]; // ������ ���� �迭
bool check[10]; // �ߺ��� ���ֱ� ���� �迭

// 1 ~ n������ �� �� �ߺ� ���� m���� ��� ������ִ� �Լ�
// ��, �׻� ���������� ������ �����
void getResult(int x, int start) {

	// 1 ~ n������ �� �� �ߺ� ���� m���� �� ������ ���
	if (x == m) {
		for (int i = 0; i < m; i++)
			printf("%d ", result[i]);
		printf("\n");
		return;
	}
	for (int i = start; i <= n; i++) {
		if (!check[i]) {      // ���� ���� �ʾҴٸ�
			check[i] = true;  // ���ϴ�
			result[x] = i;    // �迭�� �ֽ��ϴ�

			// ���� ���� ���� ���ϴ�
			// ��, ���� ������ ū ���� �� �� �ְ�
			// for���� �����ϴ� ���� i + 1�� ���ڷ� �Ѱ��ݴϴ�
			getResult(x + 1, i + 1);
			check[i] = false;  // ��� ��� Ž���� ����
		}
	}
}

int main(void) {
	scanf("%d%d", &n, &m);
	getResult(0, 1);
	return 0;
}