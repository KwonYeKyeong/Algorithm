// vector 사용 ver.
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int n, m, v, visited[1001], a, b;
vector<int> vec[1001];

bool compare(int a, int b) {
	return a < b;
}
void dfs(int idx) {
	visited[idx] = 1;
	cout << idx << ' ';

	for (int v : vec[idx]) {
		if (!visited[v])
			dfs(v);
	}
}
void bfs() {
	queue<int> q;

	q.push(v);
	visited[v] = 1;
	while (!q.empty()) {
		int qq = q.front();
		cout << qq << ' ';
		q.pop();

		for (int v : vec[qq]) {
			if (!visited[v]) {
				q.push(v);
				visited[v] = 1;
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m >> v;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		vec[a].push_back(b);
		vec[b].push_back(a);
	}

	for (int i = 1; i<1001; i++)
		sort(vec[i].begin(), vec[i].end(), compare);
	dfs(v);

	cout << '\n';

	memset(visited, 0, sizeof(visited));
	bfs();

	return 0;
}

/* vector 미사용 ver.
#include <iostream>
#include <queue>
using namespace std;

bool graph[1001][1001] = {};
queue<int> q;

void dfs(int s, bool check[]) {
	cout << s << ' ';
	check[s] = true;
	for (int i = 1; i < 1001; i++) {
		if (graph[s][i] == 0) continue;
		else {
			if (check[i] == true) continue;
			else dfs(i, check);
		}
	}
}
void bfs(int s, bool check[]) {
	q.push(s);
	check[s] = true;

	while (!q.empty()) {
		int tmp = q.front();
		q.pop();
		cout << tmp << ' ';
		for (int i = 1; i < 1001; i++) {
			if (graph[tmp][i] == 0) continue;
			else {
				if (check[i] == false) {
					q.push(i);
					check[i] = true;
				}
			}
		}
	}
}

int main() {
	bool check[1001] = {};
	int n, m, k, u, v;
	cin >> n >> m >> k;

	for (int i = 0; i < m; i++) {
		cin >> u >> v;
		graph[u][v] = true;
		graph[v][u] = true;
	}

	dfs(k, check);
	cout << '\n';
	for (int i = 1; i < 1001; i++)
		check[i] = false;
	bfs(k, check);

	return 0;
}
*/