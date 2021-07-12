#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	int c, n, k1, k2, cnt = 0;
	vector<int> vec[101];
	queue<int> q;
	bool visited[101] = {};

	cin >> c >> n;
	for (int i = 0; i < n; i++) {
		cin >> k1 >> k2;
		vec[k1].push_back(k2);
		vec[k2].push_back(k1);
	}

	q.push(1);
	visited[1] = true;
	while (!q.empty()) {
		int f = q.front();
		q.pop();
		for (int i = 0; i < vec[f].size(); i++) {
			int u = vec[f][i];
			if (!visited[u]) {
				q.push(u);
				visited[u] = true;
				cnt++;
			}
		}
	}
	cout << cnt;
	return 0;
}