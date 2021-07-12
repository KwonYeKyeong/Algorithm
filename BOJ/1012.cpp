#include <iostream>
using namespace std;

int field[51][51], dir[4][2] = { {0, -1}, {-1, 0 }, {0, 1}, {1, 0} };
int t, m, n, k, x, y;

void dfs(bool(*v)[51], int i, int j) {
	for (int d = 0; d < 4; d++) {
		int nextX = i + dir[d][0];
		int nextY = j + dir[d][1];

		if (nextX < 0 || nextX >= m
			|| nextY < 0 || nextY >= n) continue;

		if (field[nextX][nextY] && !v[nextX][nextY]) {
			v[nextX][nextY] = true;
			dfs(v, nextX, nextY);
		}

	}
}
void clear() {
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++)
			field[i][j] = 0;
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> t;
	while (t--) {
		int cnt = 0;
		bool visited[51][51] = { false };

		cin >> m >> n >> k;
		for (int i = 0; i < k; i++) {
			cin >> x >> y;
			field[x][y] = 1;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (field[i][j] && !visited[i][j]) {
					cnt++;
					visited[i][j] = true;
					dfs(visited, i, j);
				}
			}
		}
		
		cout << cnt << '\n';

		clear();
	}

	return 0;
}