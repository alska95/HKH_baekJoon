#include <iostream>
using namespace std;


template <class T>
class stack {
private:
	T dataArr[100000] = { 0, };
	int front;
public:
	stack() {
		front = 0;
	}
	void push(T data) {
		dataArr[++front] = data;
	}
	void pop() {
		if (front)
			cout << dataArr[front--] << '\n';
		else
			cout << -1 << '\n';
	}

	void size() {
		cout << front << '\n';
	}

	void empty() {
		if (front == 0)
			cout << 1 << '\n';
		else
			cout << 0 << '\n';
	}

	void top() {
		if (front)
			cout << dataArr[front] << '\n';
		else
			cout << -1 << '\n';
	}
};

int main() {
	stack<int> a;
	int orderN;
	cin >> orderN;

	string orderString;
	int orderData;
	for (int i = 0; i < orderN; i++) {
		cin >> orderString;

		if (orderString == "push") {
			cin >> orderData;
			a.push(orderData);
		}
		else if (orderString == "pop") {
			a.pop();
		}
		else if (orderString == "top") {
			a.top();
		}
		else if (orderString == "size") {
			a.size();
		}
		else if (orderString == "empty") {
			a.empty();
		}
	}
}