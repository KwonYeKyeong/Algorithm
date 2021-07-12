#include <iostream>
#include <string>
#include <stack>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	string s1, s2 = "", bomb;
	stack<char> st;
	char lastChar;

	cin >> s1 >> bomb;
	
	lastChar = bomb[bomb.length() - 1];
	for (int i = 0; i < s1.length(); i++) {
		if (s1[i] == lastChar && (st.size() >= bomb.length() - 1)) {
			s2 = s1[i];
			for (int j = 1; j < bomb.length(); j++) {
				s2 += st.top();
				st.pop();
			}
			reverse(s2.begin(), s2.end());
			if (s2 == bomb) {
				s2 = "";
				continue;
			}
			else {
				for (int j = 0; j < bomb.length(); j++)
					st.push(s2[j]);
				s2 = "";
			}
		}
		else
			st.push(s1[i]);
	}
	
	s2 = "";
	if (!st.empty()) {
		while (!st.empty()) {
			s2 += st.top();
			st.pop();
		}
		reverse(s2.begin(), s2.end());
	}
	else
		s2 = "FRULA";

	cout << s2;
	return 0;
}