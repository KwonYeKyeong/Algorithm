#include <iostream>
#include <vector>
using namespace std;

/*
struct Node {
	char data;
	Node* left;
	Node* right;
};

void preorder(Node* cur) {
	if (cur == nullptr) return;
	cout << cur->data; 
	preorder(cur->left);
	preorder(cur->right);
}

void inorder(Node* cur) {
	if (cur == nullptr) return;
	inorder(cur->left);
	cout << cur->data;
	inorder(cur->right);
}

void postorder(Node* cur) {
	if (cur == nullptr) return;
	postorder(cur->left);
	postorder(cur->right);
	cout << cur->data;
}
*/

// Node node[26];
vector<char> tree[26];

void preorder(vector<char>* vec, char r) {
	cout << r;
	for (auto a : *vec) {
		if (int(a) == -1) continue;
		preorder(&tree[int(a) - 65], a);
	}
}

void inorder(vector<char>* vec, char r) {
	bool check = false;
	for (auto a : *vec) {
		if (int(a) != -1) {
			inorder(&tree[int(a) - 65], a);
		}
		if (check == false) {
			cout << r;
			check = true;
		}
	}
}

void postorder(vector<char>* vec, char r) {
	for (auto a : *vec) {
		if (int(a) != -1) 
			postorder(&tree[int(a) - 65], a);
		continue;
	}
	cout << r;
}

int main() {
/*
	int N;
	char root, left, right;
	
	cin >> N;

	for (int i = 0; i < N; i++) {

		cin >> root >> left >> right;

		Node* n = &node[root - 'A'];
		n->data = root;
		if (left == '.') n->left = nullptr;
		else n->left = &node[left - 'A'];
		if (right == '.') n->right = nullptr;
		else n->right = &node[right - 'A'];
	}

	preorder(&node[0]);
	cout << "\n";
	inorder(&node[0]);
	cout << "\n";
	postorder(&node[0]);
*/

	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		char r, c1, c2;
		cin >> r >> c1 >> c2;
		if (c1 == '.') tree[int(r) - 65].push_back(char(-1));
		else tree[int(r)-65].push_back(c1);
		if (c2 == '.') tree[int(r) - 65].push_back(char(-1));
		else tree[int(r)-65].push_back(c2);
	}
	
	preorder(&tree[0], 'A');
	cout << '\n';
	inorder(&tree[0], 'A');
	cout << '\n';
	postorder(&tree[0], 'A');

	return 0;
}