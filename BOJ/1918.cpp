#include <iostream>
#include <stack>
using namespace std;

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