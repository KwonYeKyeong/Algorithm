#include <iostream>
#include <algorithm>
using namespace std;

int n, k, w[101], v[101], DP[101][100001];

int main() {
	ios::sync_with_stdio(0);
	
	cin >> n >> k;
	for (int i = 1; i <= n; i++)
		cin >> w[i] >> v[i];

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= k; j++) {
			DP[i][j] = DP[i - 1][j];
			if (j >= w[i])
				DP[i][j] = max(DP[i][j], DP[i - 1][j - w[i]] + v[i]);
		}
	}
	cout << DP[n][k];

	return 0;
}