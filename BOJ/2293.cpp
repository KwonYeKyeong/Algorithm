#include <iostream>
using namespace std;

int n, k, value[101], dp[10001];

int main() {
	ios::sync_with_stdio(0);

	cin >> n >> k;
	for (int i = 1; i <= n; i++)
		cin >> value[i];

	dp[0] = 1;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= k; j++) {
			if (value[i] <= j)
				dp[j] += dp[j - value[i]];
		}
	}

	cout << dp[k];

	return 0;
}
/* 메모리 초과
#include <iostream>
using namespace std;

int n, k, value[101], res[101][10001];

int main() {
	ios::sync_with_stdio(0);치

	cin >> n >> k;
	for (int i = 1; i <= n; i++)
		cin >> value[i];

	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= k; j++) {
			if (j == 0) {
				res[i][j] = 1;
				continue;
			}
			if (value[i] <= j) 
				res[i][j] = res[i - 1][j] + res[i][j - value[i]];
			else res[i][j] = res[i - 1][j];
		}
	}

	cout << res[n][k];

	return 0;
}
*/