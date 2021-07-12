#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	string s;
	stack<char> st;
	int sum = 0;
	cin >> s;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == '(') 
			st.push('(');
		else {
			st.pop();
			if (s[i - 1] == '(')
				sum += st.size();
			else
				sum++;
		}
	}
	cout << sum;
	return 0;
}