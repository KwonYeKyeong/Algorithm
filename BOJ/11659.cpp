#include <iostream>
using namespace std;

int num[100001], dp[100001];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	int n, m, s, t;

	cin >> n >> m;
	for (int i = 0; i < n; i++) 
		cin >> num[i];
	
	for (int i = 1; i <= n; i++) 
		dp[i] = dp[i - 1] + num[i - 1];

	while (m--) {
		cin >> s >> t;

		cout << dp[t] - dp[s - 1] << '\n';
	}

	return 0;
}