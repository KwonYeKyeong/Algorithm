#include <iostream>
#include <string>
using namespace std;

class Stack {
public:
	char arr[51];
	int t = -1;

	void push(char c) {
		t++;
		arr[t] = c;
	}
	void pop() {
		if(t!=-1) t--;
	}
	bool empty() {
		if (t == -1) return true;
		return false;
	}
};

/*
template <typename T>
struct stack {
	T arr[50];
	int idx = 0;
	void push(T vps) {
		arr[idx] = vps;
		idx++;
	}
	void pop() {
		idx--;
	}
	bool empty() {
		if (idx == 0) return true;
		return false;
	}
};
*/

int main() {
	int test;
	string vps;

	cin >> test;

	for (int i = 0; i < test; i++) {
		Stack st;
		bool check = true;

		cin >> vps;

		for (int j = 0; j < vps.size(); j++) {
			if (vps[j] == '(') st.push('(');
			else {
				if (st.empty()) {
					check = false;
					break;
				}
				else st.pop();
			}
		}
		if (st.empty() && check) cout << "YES\n";
		else cout << "NO\n";
	}
	return 0;
}