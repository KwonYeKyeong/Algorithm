#include <iostream>
using namespace std;

int n, k, w[10], cnt;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> n >> k;
	for (int i = 0; i < n; i++)
		cin >> w[i];

	for (int i = n - 1; i >= 0; i--) {
		if (k <= 0) break;

		while (k >= w[i]) {
			k -= w[i];
			cnt++;
		}
	}

	cout << cnt;

	return 0;
}