#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n, k, dp[100000], max = -1001;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> k;
		if (i == 0)
			dp[i] = k;
		else 
			dp[i] = (k < dp[i - 1] + k ? dp[i - 1] + k : k);
	
		max = (max < dp[i] ? dp[i] : max);
	}
	
	cout << max;

	return 0;
}