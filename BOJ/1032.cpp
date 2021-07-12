#include <iostream>
#include <string>
using namespace std;

int main() {
	int n, len;
	string s[51], file = "";

	cin >> n;
	for (int i = 0; i < n; i++) 
		cin >> s[i];

	len = s[0].length();
	for (int i = 0; i < len; i++) {
		char c = s[0][i];
		bool check = true;

		for (int j = 1; j < n; j++) {
			if (c != s[j][i]) {
				check = false;
				break;
			}
		}

		if (check)
			file += c;
		else file += '?';
	}

	cout << file;
	
	return 0;
}