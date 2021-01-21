/*
가장 긴 바이토닉 부분 수열
오름차순
내림차순
or 특정 기준 오름차순 , 내림차순 정렬된 수열

수열의 순서는 유지됨.

i를 s(중심으로 잡는다)

일단 배열 처음부터 끝까지 오름차순 결과 저정하는
dpUp[]
내림차순결과
dpDown[]

바이토닉 결과
dpBi[count] = dpUp[]+dpDown[] -1(자기자신)

for(int i = 0 ~
result = dpBi[max]
*/

#include <iostream>
using namespace std;



int main() {
	int count;
	int arr[1000]; //input값
	int upDp[1000]; //오름차순 정렬 동적배열
	int downDp[1000]; //내림차순 정렬
	int biDp[1000]; //바이토닉 

	int biggest = 0;

	cin >> count;
	for (int i = 0; i < count; i++) {
		cin >> arr[i];
	}


	for (int i = 0; i < count; i++) {
		upDp[i] = 1;
		downDp[count - i - 1] = 1;
		for (int j = 0; j < i; j++) {
			if (arr[i] > arr[j] && upDp[j] + 1 > upDp[i]) upDp[i] = upDp[j] + 1;
		} //오름차순 값 저장
	}

	for (int i = count - 1; i >= 0; i--) {
		downDp[i] = 1;
		for (int j = count - 1; j > i; j--) {
			if (arr[i] > arr[j] && downDp[j] + 1 > downDp[i]) downDp[i] = downDp[j] + 1;
		}	//내림차순 값 저장
	}
	for (int i = 0; i < count; i++) {
		biDp[i] = upDp[i] + downDp[i] - 1;
		if (biDp[i] > biggest)
			biggest = biDp[i];
	}

	cout << biggest;

}