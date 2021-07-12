/* 1锅 规过
#include <iostream>
using namespace std;

int dp[11];

int main() {
	int n, k;

	cin >> n >> k;

	dp[0] = 1;
	for (int i = 1; i <= k; i++) {
		dp[i] = dp[i - 1] * (n + 1 - i) / i;
	}

	cout << dp[k];

	return 0;
}
*/

// 2锅 规过
#include <iostream>
using namespace std;

int dp[11][11];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	int n, k;

	cin >> n >> k;

	
	for (int i = 0; i <= n; i++) {
		for (int j = 0; j <= i; j++) {
			if (j == 0 || i == j) {
				dp[i][j] = 1;
				continue;
			}
			dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
		}
	}

	cout << dp[n][k];

	return 0;
}