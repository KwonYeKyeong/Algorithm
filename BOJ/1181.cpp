#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int n;
string s[20001];

bool compare(string a, string b) {
	if (a.length() == b.length())
		return a < b;
	return a.length() < b.length();
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> s[i];

	sort(s, s + n, compare);

	for (int i = 0; i < n; i++) {
		if (i == 0 || s[i - 1] != s[i])
			cout << s[i] << '\n';
	}

	return 0;
}