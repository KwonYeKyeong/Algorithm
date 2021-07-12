#include <iostream>
#include <vector>
#include <queue>
#include <functional>
using namespace std;

const int INF = 987654321;

int v, e, k, n, m, w, d[20001];
vector<pair<int, int>> vec[20001];
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	for (int i = 0; i < 20001; i++)
		d[i] = INF;

	cin >> v >> e >> k;
	for (int i = 0; i < e; i++) {
		cin >> n >> m >> w;
		vec[n].push_back(make_pair(m, w));
	}

	d[k] = 0;
	pq.push(make_pair(0, k));
	while (!pq.empty()) {
		int ww = pq.top().first;
		int vv = pq.top().second;
		pq.pop();

		for (int i = 0; i < vec[vv].size(); i++) {
			int _vv = vec[vv][i].first;
			int _ww = vec[vv][i].second + ww;

			if (_ww < d[_vv]) {
				d[_vv] = _ww;
				pq.push(make_pair(_ww, _vv));
			}
		}
	}

	for (int i = 1; i <= v; i++) {
		if (d[i] == INF)
			cout << "INF\n";
		else cout << d[i] << '\n';
	}

	return 0;
}