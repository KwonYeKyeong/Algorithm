#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

const int INF = 987654321;

int t, k, file[501], res;
int cache[501][501], sum[501];

int dp(int idx1, int idx2) {
	if (idx1 == idx2)
		return file[idx1];

	// 이전에 계산했던 값인지 확인하는 절자
	int& r = cache[idx1][idx2]; 
	if (r != -1) return r;

	int s = sum[idx2 + 1] - sum[idx1];
	r = INF;
	for (int i = idx1; i < idx2; i++)
		r = min(r, dp(idx1, i) + dp(i + 1, idx2) + s);

	return r;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> t;
	
	while (t--) {
		memset(cache, -1, sizeof(cache));
		res = INF;

		cin >> k;
		for (int i = 0; i < k; i++)
			cin >> file[i];

		for (int i = 1; i <= k; i++)
			sum[i] = sum[i - 1] + file[i - 1];

		for (int i = 0; i < k; i++)
			res = min(res, dp(0, i) + dp(i + 1, k - 1));

		cout << res << '\n';
	}

	return 0;
}