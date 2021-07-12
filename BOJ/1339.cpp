// greedy algorithm ver.
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

const int ten[10] = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };

int n, weight[26], result = 0;
string s[11];

bool compare(int a, int b) {
	return a > b;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> s[i];
		int len = s[i].length();
		for (int j = 0; j < len; j++) {
			int idx = s[i][j] - 'A';
			weight[idx] += ten[len - 1 - j];
		}
	}

	sort(weight, weight + 26, compare);

	int s = 0;
	for (int i = 9; i >= 0; i--)
		result += i * weight[s++];
	
	cout << result;

	return 0;
}

/* backtracking ver.
#include <iostream>
#include <string>
#include <math.h>
using namespace std;

const int ten[10] = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };

int n, m = 0, alpha[26], num[26], result;
string s[11];

int calculate(int* number) {
	int r = 0;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < s[i].length(); j++)
			r += number[s[i][j] - 'A'] * ten[s[i].length() - j - 1];
	}

	return r;
}

void solve(int* number, int s, int cnt) {
	if (++cnt > m) {
		result = result < calculate(number) ? calculate(number) : result;
		return;
	}
	if (s < 10 - m) return;

	for (int i = 0; i < 26; i++) {
		if (alpha[i] && number[i] == -1) {
			number[i] = s;
			solve(number, s - 1, cnt);
			number[i] = -1;
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	for (int i = 0; i < 26; i++)
		num[i] = -1;

	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> s[i];

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < s[i].length(); j++) {
			int idx = s[i][j] - 'A';
			if (!alpha[idx]) {
				alpha[idx] = 1;
				m++;
			}
		}
	}

	solve(num, 9, 0);

	cout << result;

	return 0;
}
*/