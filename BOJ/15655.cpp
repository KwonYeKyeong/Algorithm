#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, m, N[9], check[9];
vector<int> vec;

void solve(int cnt, int s) {
	if (cnt == m) {
		for (int v : vec)
			cout << v << ' ';
		cout << '\n';
		return;
	}

	for (int i = s; i < n; i++) {
		if (!check[i]) {
			vec.push_back(N[i]);
			check[i] = true;
			solve(cnt + 1, i + 1);
			vec.pop_back();
			check[i] = false;
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++)
		cin >> N[i];

	sort(N, N + n);

	solve(0, 0);

	return 0;
}