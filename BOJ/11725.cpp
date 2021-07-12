#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<vector<int>> vec;
int parent[100001];
bool check[100001];

void bfs() {
	queue<int> q;
	q.push(1);
	check[1] = true;

	while (!q.empty()) {
		int x = q.front();
		q.pop();

		for (auto y : vec[x]) {
			if (!check[y]) {
				parent[y] = x;
				check[y] = true;
				q.push(y);
			}
		}
	}
}

int main() {
	int N;
	cin >> N;

	vec.resize(N + 1);

	for (int i = 0; i < N - 1; i++) {
		int a, b;
		cin >> a >> b;
		vec[a].push_back(b);
		vec[b].push_back(a);
	}

	bfs();

	for (int j = 2; j <= N; j++)
		cout << parent[j] << '\n';

	return 0;
}