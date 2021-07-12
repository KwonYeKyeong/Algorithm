#include <iostream>
using namespace std;

struct Robot {
	int x, y;
	void setPos(int xx, int yy) {
		x = xx;
		y = yy;
	}
};

int room[51][51], visited[51][51];
int dir[4][2] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
int n, m, a, b, d, cnt = 0;
Robot r;

int goBack(int d) {
	switch (d) {
	case 0:
		return 2;
	case 1: 
		return 3;
	case 2:
		return 0;
	case 3:
		return 1;
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> n >> m;
	cin >> a >> b >> d;
	r.setPos(a, b);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) 
			cin >> room[i][j];
	}

	visited[r.x][r.y] = 1;
	cnt++;
	while (1) {
		int check = 0;
		for (int i = 1; i <= 4; i++) {
			int k = (d - i >= 0 ? d - i : d - i + 4);
			int nextX = r.x + dir[k][0];
			int nextY = r.y + dir[k][1];
			if (!visited[nextX][nextY] && !room[nextX][nextY]) {
				visited[nextX][nextY] = 1;
				cnt++;
				d = k;
				r.setPos(nextX, nextY);
				break;
			}
			else
				check++;
		}

		if (check == 4) {
			int nextX = r.x + dir[goBack(d)][0];
			int nextY = r.y + dir[goBack(d)][1];
			if (room[nextX][nextY])
				break;
			else 
				r.setPos(nextX, nextY);
		}
	}

	cout << cnt;

	return 0;
}