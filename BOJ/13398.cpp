#include<iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);

	int n, k, result;
	int dp[100000][2]; // dp[i][0]: 버리지 않는 경우, dp[i][1]: 1개 버린 경우

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> k;
		if (i == 0) {
			dp[i][0] = dp[i][1] = k;
			result = k;
		}
		else {
			dp[i][0] = (k < (k + dp[i - 1][0]) ? (k + dp[i - 1][0]) : k);
			dp[i][1] = (dp[i - 1][0] < dp[i - 1][1] + k ? dp[i - 1][1] + k : dp[i - 1][0]);
		}
	}
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < n; j++) 
			result = (result < dp[j][i] ? dp[j][i] : result);
	}
	cout << result;
	return 0;
}


