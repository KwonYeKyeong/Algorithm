#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	int n, p[10001], idx = -1;

	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> p[i];

	for (int i = n; i > 1; i--) {
		if (p[i] < p[i - 1]) continue;
		else if (p[i] > p[i - 1]) {
			idx = i;
			break;
		}
	}
	if (idx == -1) {
		cout << -1;
		return 0;
	}

	for (int i = n; i >= idx; i--) {
		if (p[i] > p[idx - 1]) {
			int tmp = p[i];
			p[i] = p[idx - 1];
			p[idx - 1] = tmp;
			break;
		}
	}

	sort(p + idx, p + n + 1);

	for (int i = 1; i <= n; i++)
		cout << p[i] << ' ';

	return 0;
}