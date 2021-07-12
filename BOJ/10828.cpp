#include <iostream>
#include <stack>
#include <string>
using namespace std;
/*
int main() {

	cin.tie(NULL);
	std::ios::sync_with_stdio(false);

	int N; // 명령의 수
	string s;
	stack<int> st;
	int X;

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> s;
		if (s == "push") {
			cin >> X;
			st.push(X);
		}
		else if (s == "top") {
			if (st.empty() == 1)
				cout << -1 << "\n";
			else cout << st.top() << "\n";
		}
		else if (s == "pop") {
			if (st.empty() == 1)
				cout << -1 << "\n";
			else
			{
				cout << st.top() << "\n";
				st.pop();
			}
		}
		else if (s == "size") {
			cout << st.size() << "\n";
		}
		else if (s == "empty") {
			cout << st.empty() << "\n";
		}
	}
	return 0;
}
*/

class Stack {
public:
	int s[10001] = {};
	int t = -1;

	void push(int X) {
		t++;
		s[t] = X;
	}
	int pop() {
		if (t == -1) return -1;
		else {
			int value = s[t];
			t--;
			return value;
		}
	}
	int size() {
		return (t + 1);
	}
	bool empty() {
		if (t == -1) return true;
		return false;
	}
	int top() {
		if (t == -1) return -1;
		else return s[t];
	}
};

int main() {
	int N;
	Stack st;
	string s;

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> s;
		if (s == "push") {
			int k;
			cin >> k;
			st.push(k);
		}
		else if (s == "top") {
			cout << st.top() << '\n';
		}
		else if (s == "size")
			cout << st.size() << '\n';
		else if (s == "empty") {
			cout << st.empty() << '\n';
		}
		else if (s == "pop") {
			cout << st.pop() << '\n';
		}
	}
	return 0;
}