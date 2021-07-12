#include <iostream>
#include <cstring>
using namespace std;

int board[501][501];
bool visited[501][501];
int n, m, maxx;
int dx[] = { 0,-1,0,1 };
int dy[] = { -1,0,1,0 };

bool over(int x, int y) {
	if (x < 0 || x >= n || y < 0 || y >= m)
		return true;
	return false;
}
void DFS(int cnt, int x, int y, int s) {
	if (cnt == 4) {
		maxx = (s > maxx ? s : maxx);
		return;
	}

	s += board[x][y];
	cnt++;
	visited[x][y] = true;
	for (int i = 0; i < 4; i++) {
		int nextX = x + dx[i];
		int nextY = y + dy[i];
		if (!over(nextX, nextY) && !visited[nextX][nextY]) {
			DFS(cnt, nextX, nextY, s);
			visited[nextX][nextY] = false;
		}
	}
}
void solve() {
	int sum;
	// ぬ で
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m - 2; j++) {
			sum = board[i][j] + board[i][j + 1] + board[i][j + 2];
			if (i == 0) {
				sum += board[i + 1][j + 1];
				maxx = (sum > maxx ? sum : maxx);
			}
			else if (i == n-1) {
				sum += board[i - 1][j + 1];
				maxx = (sum > maxx ? sum : maxx);
			}
			else {
				maxx = (sum + board[i + 1][j + 1] > maxx ? sum + board[i + 1][j + 1]:maxx);
				maxx = (sum + board[i - 1][j + 1] > maxx ? sum + board[i - 1][j + 1] : maxx);
			}
		}
	}
	// た っ
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n - 2; j++) {
			sum = board[j][i] + board[j + 1][i] + board[j + 2][i];
			if (i == 0) {
				sum += board[j + 1][i + 1];
				maxx = (sum > maxx ? sum : maxx);
			}
			else if (i == m - 1) {
				sum += board[j + 1][i - 1];
				maxx = (sum > maxx ? sum : maxx);
			}
			else {
				maxx = (sum + board[j + 1][i + 1] > maxx ? sum + board[j + 1][i + 1] : maxx);
				maxx = (sum + board[j + 1][i - 1] > maxx ? sum + board[j + 1][i - 1] : maxx);
			}
		}
	}
}
int main() {
	ios::sync_with_stdio(0);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			cin >> board[i][j];
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			memset(visited, false, sizeof(visited));
			DFS(0, i, j, 0);
		}
	}
	solve();
	
	cout << maxx;

	return 0;
}