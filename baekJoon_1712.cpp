/*
월드전자 a만원 고정비용
한대의 노트북 b만원 가변비용

노트북 가격 c만원
손익 분기점 a + b*노트북 대수 = c*노트북 대수
			== a/ (c-b)
*/
#include <cstdio>
using namespace std;

int main() {

	int a, b, c;
	scanf("%d %d %d", &a, &b, &c);

	if (b >= c) printf("-1\n");
	else printf("%d\n", a / (c - b) + 1);
	return 0;
}