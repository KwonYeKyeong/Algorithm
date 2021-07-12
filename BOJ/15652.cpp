#include <iostream>
#include <vector>
using namespace std;

int n, m;
vector<int> vec;

void solve(int cnt, int s) {
	if (cnt == m) {
		for (int v : vec)
			cout << v << ' ';
		cout << '\n';
		return;
	}

	for (int i = s; i <= n; i++) {
		vec.push_back(i);
		solve(cnt + 1, i);
		vec.pop_back();
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> n >> m;

	solve(0, 1);

	return 0;
}