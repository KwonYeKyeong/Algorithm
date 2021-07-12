#include <iostream>
#include <algorithm>
using namespace std;

int res[101][10001];

int main() {
	ios::sync_with_stdio(0);
	int n, k, value[101];

	cin >> n >> k;
	for (int i = 1; i <= n; i++)
		cin >> value[i];

	for (int i = 0; i <= n; i++) {
		for (int j = 0; j <= k; j++) {
			if (i == 0) {
				res[i][j] = 10001;
				continue;
			}
			if (j == 0) {
				res[i][j] = 0;
				continue;
			}
			if (j >= value[i])
				res[i][j] = min(res[i - 1][j], res[i][j - value[i]] + 1);
			else res[i][j] = res[i - 1][j];
		}
	}
	
	if (res[n][k] == 10001) cout << -1;
	else cout << res[n][k];

	return 0;
}