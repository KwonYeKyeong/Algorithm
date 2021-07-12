#include <iostream>
#include <string>
using namespace std;
/*
template <typename T>
class stack {
private:
	T arr[101];
	int index = 0;
public:
	void push(T t){
		arr[index] = t;
		this->index += 1;
	}
	void pop() {
		this->index -= 1;
	}
	T top() {
		return arr[index - 1];
	}
	bool empty() {
		if (index == 0)
			return true;
		return false;
	}
}; 

int main() {
	char s[101];
	stack<char> st;

	cin.getline(s, 100);

	for (int i = 0; s[i] != NULL; i++) {
		if (s[i] == '*' || s[i] == '/') {
			while (!st.empty()) {
				if (st.top() == '*' || st.top() == '/') {
					cout << st.top();
					st.pop();
				}
				else break;
			}
			st.push(s[i]);
		}
		else if (s[i] == '+' || s[i] == '-') {
			while (!st.empty()) {
				if (st.top() == '*' || st.top() == '/'
					|| st.top() == '+' || st.top() == '-') {
					cout << st.top();
					st.pop();
				}
				else break;
			}
			st.push(s[i]);
		}
		else if (s[i] == '(')
			st.push(s[i]);
		else if (s[i] == ')') {
			while (st.top() != '(') {
				cout << st.top();
				st.pop();
			}
			if (st.top() == '(')
				st.pop();
		}
		else
			cout << s[i];
	}

	while (!st.empty()) {
		cout << st.top();
		st.pop();
	}

	return 0;
}
*/

class stack {
public:
	char arr[101];
	int t = -1;

	void push(char X) {
		t++;
		arr[t] = X;
	}
	char pop() {
		char c;
		if (t != -1) {
			c = arr[t];
			t--;
		}
		return c;
	}
	char top() {
		char c;
		if (t != -1) c = arr[t];
		return c;
	}
	bool empty() {
		if (t == -1) return true;
		return false;
	}
};


int main() {
	stack st;
	string s;

	cin >> s;

	for (int i = 0; i < s.length(); i++) {
		if (s[i] == '(') st.push('(');
		else if (s[i] == ')') {
			while (st.top() != '(') {
				cout << st.top();
				st.pop();
			}
			if (st.top() == '(') st.pop();
		}
		else if (s[i] == '*' || s[i] == '/') {
			while (!st.empty()) {
				if (st.top() == '*' || st.top() == '/') {
					cout << st.top();
					st.pop();
				}
				else break;
			}
			st.push(s[i]);
		}
		else if (s[i] == '+' || s[i] == '-') {
			while (!st.empty()) {
				if (st.top() == '+' || st.top() == '-'
					|| st.top() == '*' || st.top() == '/') {
					cout << st.top();
					st.pop();
				}
				else break;
			}
			st.push(s[i]);
		}
		else cout << s[i];
	}
	while (!st.empty()) {
		cout << st.pop();
	}
	return 0;
}