#include <iostream>
#include <queue>
#include <cstring>
#include <algorithm>
using namespace std;

int n, m, map[8][8], tmp[8][8], safe = -1;
int dx[] = { 0, -1, 0, 1 };
int dy[] = { -1, 0, 1, 0 };
queue<pair<int, int>> q;

bool over(int x, int y) {
	if (x < 0 || x >= n || y < 0 || y >= m)
		return true;
	return false;
}
void BFS() {
	int afterWall[8][8];
	queue<pair<int, int>> afterWall_q = q;
	memcpy(afterWall, tmp, sizeof(tmp));

	while (!afterWall_q.empty()) {
		pair<int, int> u = afterWall_q.front();
		afterWall_q.pop();
		for (int i = 0; i < 4; i++) {
			int nextX = u.first + dx[i];
			int nextY = u.second + dy[i];
			if (!over(nextX, nextY) && afterWall[nextX][nextY] == 0) {
				afterWall[nextX][nextY] = 2;
				afterWall_q.push({ nextX, nextY });
			}
		}
	}

	int cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (afterWall[i][j] == 0) cnt++;
		}
	}
	safe = max(safe, cnt);
}
void makeWall(int cnt) {
	if (cnt == 3) {
		BFS();
		return;
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (tmp[i][j] == 0) {
				tmp[i][j] = 1;
				makeWall(cnt + 1);
				tmp[i][j] = 0;
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(0);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
			if (map[i][j] == 2)
				q.push({ i, j });
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 0) {
				memcpy(tmp, map, sizeof(map));
				tmp[i][j] = 1;
				makeWall(1);
				tmp[i][j] = 0;
			}
		}
	}
	
	cout << safe;

	return 0;
}