#include <iostream>
using namespace std;

int n, MAX;
int A[1001], dp[1001];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> A[i];

	for (int i = 0; i < n; i++) {
		dp[i] = 1;
		for (int j = 0; j < i; j++) {
			if (A[i] < A[j] && dp[i] < dp[j] + 1)
				dp[i] = dp[j] + 1;
		}
		if (MAX < dp[i])
			MAX = dp[i];
	}

	cout << MAX;

	return 0;
}