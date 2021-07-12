#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int lcs[1002][1002];

int main() {
	ios::sync_with_stdio(0);
	string s1, s2, x, y;

	cin >> s1 >> s2;

	x = '0' + s1;
	y = '0' + s2;

	for (int i = 0; i < x.length(); i++) {
		for (int j = 0; j < y.length(); j++) {
			if (i == 0 || j == 0) {
				lcs[i][j] = 0;
				continue;
			}
			if (x[i] == y[j])
				lcs[i][j] = lcs[i - 1][j - 1] + 1;
			else
				lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1]);
		}
	}

	cout << lcs[s1.length()][s2.length()];

	return 0;
}