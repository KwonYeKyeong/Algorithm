#include <iostream>
#include <queue>
#include <vector>
#include <functional>
using namespace std;

const int MAX = 200000;
const int INF = 987654321;

priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
int d[MAX + 1], n, k;

int main() {
	for (int i = 0; i < MAX + 1; i++)
		d[i] = INF;

	cin >> n >> k;

	// dijkstra
	d[n] = 0;
	pq.push(make_pair(0, n));
	while (!pq.empty()) {
		int val = pq.top().first;
		int cur = pq.top().second;
		pq.pop();

		if (d[cur] < val) continue; // 최단경로가 아닌 경우 skip
		for (int i = 0; i < 3; i++) {
			int v, c;

			if (i == 0) {
				v = val;
				c = cur * 2;
			}
			else {
				v = val + 1;
				if (i == 1)
					c = cur - 1;
				else c = cur + 1;
			}
			
			if (c<0 || c>MAX) continue;
			if (d[c] == INF || d[c] > v) {
				d[c] = v;
				pq.push(make_pair(v, c));
			}
		}
	}

	cout << d[k];

	return 0;
}