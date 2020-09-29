/*
µ¢Ä¡ 7568

*/
#include <iostream>
using namespace std;

class Frame {
private:
	int x = 0;
	int y = 0;
	int count = 1;
public:
	void getrank(int totalNum) {
		Frame rank[50];
		for (int i = 0; i < totalNum; i++) {
			cin >> rank[i].x >> rank[i].y;
		}
		for (int i = 0; i < totalNum; i++) {
			for (int j = 0; j < totalNum; j++) {
				if (rank[i].x < rank[j].x && rank[i].y < rank[j].y)
					rank[i].count++;
			}
		}
		for (int i = 0; i < totalNum; i++)
			cout << rank[i].count << ' ';
	}
};

int main() {
	Frame frame;
	int n;
	cin >> n;
	frame.getrank(n);
}