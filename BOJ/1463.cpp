#include <iostream>
#include <algorithm>
using namespace std;

int dp[1000001];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	int n;

	cin >> n;

	for (int i = 2; i <= n; i++) {
		if (i % 3 == 0) {
			if (i % 2 == 0)
				dp[i] = min(dp[i - 1], min(dp[i / 2], dp[i / 3])) + 1;
			else dp[i] = min(dp[i - 1], dp[i / 3]) + 1;
		}
		else if (i % 2 == 0)
			dp[i] = min(dp[i - 1], dp[i / 2]) + 1;
		else dp[i] = dp[i - 1] + 1;
	}

	cout << dp[n];

	return 0;
}