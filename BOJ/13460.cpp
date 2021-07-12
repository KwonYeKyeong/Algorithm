#include <iostream>
using namespace std;

struct Marble {
	int x, y;
	void setPos(int xx, int yy) {
		x = xx;
		y = yy;
	}
};

const int MAX_TRY = 10;

char board[11][11];
int dir[4][2] = { {0, -1}, {-1, 0}, {0, 1}, {1, 0} };
int n, m, cnt = MAX_TRY + 1;
Marble red, blue;

void solve(Marble r, Marble b, int d, int c) {
	if (++c > MAX_TRY)
		return;

	bool checkR = false, checkB = false; // 목적지에 도착했는가
	int order = 0; // 0 : R 먼저, 1 : B 먼저
	switch (d) {
	case 0:
		if (b.y < r.y)
			order = 1;
		break;
	case 1:
		if (b.x < r.x)
			order = 1;
		break;
	case 2:
		if (b.y > r.y)
			order = 1;
		break;
	case 3:
		if (b.x > r.x)
			order = 1;
	}

	if (order == 0) {
		while (1) { // R
			int nextX = r.x + dir[d][0];
			int nextY = r.y + dir[d][1];
			if (board[nextX][nextY] == '#')
				break;
			if (board[nextX][nextY] == 'O') {
				checkR = true;
				r.x = r.y = -1;
				break;
			}
			r.x = nextX;
			r.y = nextY;
		}
		while (1) { // B
			int nextX = b.x + dir[d][0];
			int nextY = b.y + dir[d][1];
			if (board[nextX][nextY] == '#' ||
				(nextX == r.x && nextY == r.y)) break;
			if (board[nextX][nextY] == 'O') {
				checkB = true;
				b.x = b.y = -1;
				break;
			}
			b.x = nextX;
			b.y = nextY;
		}
	}
	else {
		while (1) { // B
			int nextX = b.x + dir[d][0];
			int nextY = b.y + dir[d][1];
			if (board[nextX][nextY] == '#')
				break;
			if (board[nextX][nextY] == 'O') {
				checkB = true;
				b.x = b.y = -1;
				break;
			}
			b.x = nextX;
			b.y = nextY;
		}
		while (1) { // R
			int nextX = r.x + dir[d][0];
			int nextY = r.y + dir[d][1];
			if (board[nextX][nextY] == '#' ||
				(nextX == b.x && nextY == b.y)) break;
			if (board[nextX][nextY] == 'O') {
				checkR = true;
				r.x = r.y = -1;
				break;
			}
			r.x = nextX;
			r.y = nextY;
		}
	}
	if (checkB) return;
	else if (checkR) {
		cnt = (cnt < c ? cnt : c);
		return;
	}
	for (int i = 0; i < 4; i++) {
		if(i != d || i%2 != d%2)
			solve(r, b, i, c);
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> board[i][j];
			if (board[i][j] == 'R') {
				red.setPos(i, j);
				board[i][j] = '.';
			}
			else if (board[i][j] == 'B') {
				blue.setPos(i, j);
				board[i][j] = '.';
			}
		}
	}

	for (int i = 0; i < 4; i++)
		solve(red, blue, i, 0);

	if (cnt == MAX_TRY + 1)
		cout << -1;
	else cout << cnt;

	return 0;
}