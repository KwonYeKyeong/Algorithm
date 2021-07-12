#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int n, k, m;
vector<int> vec[200001];
int rumor[200001];
queue<int> q;

int main() {
	ios::sync_with_stdio(0);
	
	memset(rumor, -1, sizeof(rumor));
	cin >> n;
	for (int i = 1; i <= n; i++) {
		while (cin >> k) {
			if (k == 0) break;
			vec[i].push_back(k);
		}
	}
	cin >> m;
	while (m--) {
		cin >> k;
		q.push(k);
		rumor[k] = 0;
	}

	while (!q.empty()) {
		int u = q.front();
		q.pop();
		for (int v : vec[u]) {
			if (rumor[v] < 0) {
				int cnt = 0;
				for (int w : vec[v]) {
					if (rumor[w] > rumor[u] || rumor[w] < 0)
						cnt++;
				}
				if (cnt <= vec[v].size() / 2) {
					q.push(v);
					rumor[v] = rumor[u] + 1;
				}
			}
		}
	}
	
	for (int i = 1; i <= n; i++)
		cout << rumor[i] << ' ';

	return 0;
}