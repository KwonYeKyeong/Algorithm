#include <iostream>
using namespace std;

int RGB[1001][4];
int dp[1001][4];

int min(int a, int b) {
	return (a <= b ? a : b);
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, r, g, b, minIdx;

	cin >> n;
	
	for (int i = 1; i <= n; i++) {
		cin >> r >> g >> b;
		RGB[i][1] = r;
		RGB[i][2] = g;
		RGB[i][3] = b;

		if (i == 1) {
			dp[i][1] = RGB[i][1];
			dp[i][2] = RGB[i][2];
			dp[i][3] = RGB[i][3];
		}
		else {
			dp[i][1] = min(dp[i - 1][2], dp[i - 1][3]) + RGB[i][1];
			dp[i][2] = min(dp[i - 1][1], dp[i - 1][3]) + RGB[i][2];
			dp[i][3] = min(dp[i - 1][1], dp[i - 1][2]) + RGB[i][3];
		}
	}

	cout << (min(dp[n][1], dp[n][2]) <= dp[n][3] ? min(dp[n][1], dp[n][2]) : dp[n][3]);

	return 0;
}