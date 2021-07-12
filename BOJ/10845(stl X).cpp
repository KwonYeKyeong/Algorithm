#include <iostream>
#include <string>
using namespace std;

class queue {
public:
	int arr[10000];
	int f = 0;
	int r = -1;

	void push(int X) {
		r++;
		arr[r] = X;
	}
	int pop() {
		if (f > r) return -1;
		else {
			int ret = arr[f];
			f++;
			return ret;
		}
	}
	int size() {
		return (r - f) + 1;
	}
	bool empty() {
		if (f > r) return true;
		return false;
	}
	int front() {
		if (f > r) return -1;
		else return arr[f];
	}
	int back() {
		if (f > r) return -1;
		else return arr[r];
	}
};

int main() {
	int N;
	queue q;
	string s;
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> s;
		if (s == "push") {
			int k;
			cin >> k;
			q.push(k);
		}
		else if (s == "pop")
			cout << q.pop() << '\n';
		else if (s == "size")
			cout << q.size() << '\n';
		else if (s == "empty")
			cout << q.empty() << '\n';
		else if (s == "front")
			cout << q.front() << '\n';
		else if (s == "back")
			cout << q.back() << '\n';
	}
	return 0;
}