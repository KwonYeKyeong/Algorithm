#include <iostream>
using namespace std;

int n, k, cnt, dolls[1000001], f, e;
int MIN = 987654321;

bool over(int a) {
	if (a < 0 || a >= n)
		return true;
	return false;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		cin >> dolls[i];

		if (dolls[i] == 1)
			cnt++;
	}

	if (cnt < k)
		cout << -1;
	else {
		cnt = (dolls[0] == 1 ? 1 : 0);
		while (true) {
			if (cnt < k) {
				if (!over(++e))
					cnt = (dolls[e] == 1 ? cnt + 1 : cnt);
				else break;
			}
			else {
				MIN = (MIN > e - f + 1 ? e - f + 1 : MIN);

				if (!over(++f)) 
					cnt = (dolls[f - 1] == 1 ? cnt - 1 : cnt);
				else break;
			}
		}

		cout << MIN;
	}

	return 0;
}