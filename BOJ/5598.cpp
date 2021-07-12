#include <iostream>
#include <string>
using namespace std;

int main() {
	string s, r = "";

	cin >> s;

	for (int i = 0; i < s.length(); i++) {
		if (s[i] < 'D') r += s[i] + 23;
		else r += s[i] - 3;
	}

	cout << r;
	
	return 0;
}