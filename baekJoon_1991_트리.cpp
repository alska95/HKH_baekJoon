#include <iostream>

#define max 30

using namespace std;

class HwangsTree {
private:
	int tree[max][2];
	int size;
public:
	void setSize(int _size) {
		size = _size;
	}
	int getSize() {
		return size;
	}

	void run() {
		cin >> size;
		char root, left, right;
		for (int i = 0; i < size; i++) {
			cin >> root >> left >> right;
			push(root, left, right);
		}
		display();
	}
	void push(int root, int left, int right) {
		tree[root - 'A'][0] = (left != '.' ? left - 'A' : -1);
		tree[root - 'A'][1] = (right != '.' ? right - 'A' : -1);
	}

	void preOrder(int node) {
		if (node != -1) {
			cout << char(node + 'A');
			preOrder(tree[node][0]);
			preOrder(tree[node][1]);
		}

	}

	void inOrder(int node) {
		if (node != -1) {
			inOrder(tree[node][0]);
			cout << char(node + 'A');
			inOrder(tree[node][1]);
		}

	}

	void postOrder(int node) {
		if (node != -1) {
			postOrder(tree[node][0]);
			postOrder(tree[node][1]);
			cout << char(node + 'A');
		}
	}

	void display() {
		preOrder(0);
		cout << '\n';
		inOrder(0);
		cout << '\n';
		postOrder(0);
	}
};

int main() {
	HwangsTree tree;
	tree.run();
}