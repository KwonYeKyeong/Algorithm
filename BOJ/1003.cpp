#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	int t, n;
	pair<int, int> f[41];

	f[0] = { 1,0 };
	f[1] = { 0,1 };
	for (int i = 2; i <= 40; i++) {
		f[i].first = f[i - 1].first + f[i - 2].first;
		f[i].second = f[i - 1].second + f[i - 2].second;
	}

	cin >> t;
	while (t--) {
		cin >> n;
		cout << f[n].first << ' ' << f[n].second << '\n';
	}
	return 0;
}