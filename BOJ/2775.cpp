#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	int t, k, n, apartment[15][15];
	cin >> t;
	while (t--) {
		cin >> k >> n;
		for (int i = 0; i <= k; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					apartment[i][j] = j;
					continue;
				}
				apartment[i][j] = apartment[i][j - 1] + apartment[i - 1][j];
			}
		}
		cout << apartment[k][n] << '\n';
	}
	return 0;
}