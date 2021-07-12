#include <iostream>
using namespace std;

int n, m, A[10001], sum[10001], idx1, idx2, cnt;

bool over(int a, int b) {
	if (a < 0 || a >= n || b < 0 || b >= n)
		return true;
	return false;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);
	
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> A[i];
		sum[i + 1] = sum[i] + A[i];
	}

	while (!over(idx1, idx2)) {
		int tmp = sum[idx2 + 1] - sum[idx1];

		if (tmp > m)
			idx1++;
		else {
			idx2++;
			if (tmp == m) cnt++;
		}
	}

	cout << cnt;

	return 0;
}