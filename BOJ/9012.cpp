#include <iostream>
#include <stack>
#include <string>
using namespace std;


int main() {
	int T; // 테스트 케이스 개수
	stack<char> st;
	string vps;
	bool print = false;

	cin >> T;

	for (int i = 0; i < T; i++) {
		while (!st.empty()) st.pop();
		print = false;

		cin >> vps;
		
		for (int j = 0; j < vps.length(); j++) {
			if (vps.at(j) == '(')
				st.push('(');
			else {
				if (st.empty()) {
					print = true;
					break;
				}
				else st.pop();
			}
		}
		if (st.empty() && print == false)
			cout << "YES\n";
		else cout << "NO\n";
	}

	return 0;
}