#include <iostream>
#include <vector>
using namespace std;

int n, m, f1, f2, visited[2000];
vector<int> vec[2000];
bool _existed = false;

void dfs(int cnt, int s) {
	if (cnt == 4)
		_existed = true;
	if (_existed) return;

	for (int v : vec[s]) {
		if (!visited[v]) {
			visited[v] = 1;
			dfs(cnt + 1, v);
			visited[v] = 0;
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);
	
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		cin >> f1 >> f2;
		vec[f1].push_back(f2);
		vec[f2].push_back(f1);
	}

	for (int i = 0; i < n; i++) {
		if (_existed) break;
		visited[i] = 1;
		dfs(0, i);
		visited[i] = 0;
	}
	
	cout << _existed;

	return 0;
}