/*
백준 1002번
좌표 a : a1 ,a2
좌표 b : b1 ,b2
거리 r : ra , rb
if a = b , ra = rb -1
if ra + rb = abl -> 1
if ra + rb > abl -> 2
if ra + rb < abl -> 0
*/
#include <iostream>
#include <math.h>
using namespace std;



int solve(int a1, int a2, double ra, int b1, int b2, double rb) {
	double distance = sqrt(pow(b1 - a1, 2) + pow(b2 - a2, 2));
	if (a1 == b1 && a2 == b2 && ra == rb)
		return -1;
	if (ra + rb < distance || distance < fabs(ra - rb)) //원이 안에 들어가있을경우 , 안닿을경우
		return 0;
	if (ra + rb == distance || fabs(ra - rb) == distance) //외접 , 내접
		return 1;
	if (ra + rb > distance)
		return 2;

}

int main() {
	int a1, a2, b1, b2;
	double ra, rb;

	int count;

	cin >> count;
	for (int i = 0; i < count; i++) {
		cin >> a1 >> a2 >> ra >> b1 >> b2 >> rb;
		cout << solve(a1, a2, ra, b1, b2, rb) << '\n';
	}
}