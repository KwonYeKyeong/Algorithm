#include <iostream>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	int n, cnt = 0;
	string s;

	cin >> n;
	
	while (n--) {
		int alpha[26] = {};
		bool group = true;

		cin >> s;

		alpha[s[0] - 'a'] = 1;
		for (int i = 1; i < s.length(); i++) {
			if (!group) break;

			if (s[i] != s[i - 1] && alpha[s[i] - 'a'])
				group = false;
			else alpha[s[i] - 'a'] = 1;
		}

		if (group) cnt++;
	}

	cout << cnt;

	return 0;
}