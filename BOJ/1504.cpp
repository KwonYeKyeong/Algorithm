/*
문제 : 1 -> n의 최단경로를 구하되, v1, v2를 반드시 지나야함.
조건 : 한번 이동했던 정점, 간선 다시 이동 가능 / 경로가 존재하지 않는 경우 -1 출력
알고리즘 및 풀이 : 다익스트라 /	1. 1 -> v1-> v2 -> n
								2. 1 -> v2 -> v1 -> n 둘 중 최소값
								경로가 존재하지 않는 경우 = 최소값이 INF 이상 또는 0 미만일 경우
														  (0 미만인 이유 : INF + INF + INF = 오버플로우 -> 음수)
*/
#include <iostream>
#include <vector>
#include <queue>
#include <functional>
#include <algorithm>
using namespace std;

const int INF = 987654321;

int n, e, a, b, c, v1, v2;
vector<pair<int, int>> vec[801];

vector<int> dijkstra(int start) {
	vector<int> d(n + 1, INF);
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

	d[start] = 0;
	pq.push(make_pair(0, start));
	while (!pq.empty()) {
		int dis = pq.top().first;
		int num = pq.top().second;
		pq.pop();

		for (pair<int, int> p : vec[num]) {
			if (p.second + dis < d[p.first]) {
				d[p.first] = p.second + dis;
				pq.push(make_pair(d[p.first], p.first));
			}
		}
	}

	return d;
}
void input() {
	cin >> n >> e;

	for (int i = 0; i < e; i++) {
		cin >> a >> b >> c;
		vec[a].push_back(make_pair(b, c));
		vec[b].push_back(make_pair(a, c));
	}

	cin >> v1 >> v2;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	input();

	vector<int> one = dijkstra(1);
	vector<int> two = dijkstra(v1);
	vector<int> three = dijkstra(v2);

	int res = min(one[v1] + two[v2] + three[n], one[v2] + two[n] + three[v1]);
	
	if (res >= INF || res < 0)
		cout << -1;
	else cout << res;

	return 0;
}