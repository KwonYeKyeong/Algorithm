#include <iostream>
using namespace std;

int min(int a, int b) {
	return (a < b ? a : b);
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	int n, k;
	int low, high, mid, cnt, res;

	cin >> n >> k;

	low = 1;
	high = k;
	while (low <= high) {
		cnt = 0;
		mid = (low + high) / 2;

		for (int i = 1; i <= n; i++) 
			cnt += min(mid / i, n); // 각 행별로 mid보다 작은 숫자의 개수

		if (cnt >= k) {
			res = mid;
			high = mid - 1;
		}
		else
			low = mid + 1;
	}
	
	cout << res;

	return 0;
}