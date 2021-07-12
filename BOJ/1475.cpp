#include <iostream>
#include <string>
using namespace std;

int set[9];

int main() {
	string s;
	int max = 0;
	cin >> s;

	for (int i = 0; i < s.length(); i++) {
		if ((s[i] - '0') == 9)
			set[6]++;
		else set[(s[i] - '0')]++;
	}
	for (int i = 0; i < 9; i++) {
		if (i == 6) {
			if (set[i] % 2 == 0)
				max = (max < (set[i] / 2) ? (set[i] / 2) : max);
			else
				max = (max < (set[i] / 2 + 1) ? (set[i] / 2 + 1) : max);
		}
		else max = (max < set[i] ? set[i] : max);
	}

	cout << max;

	return 0;
}