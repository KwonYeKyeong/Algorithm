#include <iostream>
using namespace std;

struct Robot {
	int x, y, d;
	void setPos(int xx, int yy, char dd) {
		x = xx;
		y = yy;
		switch (dd) {
		case 'N':
			d = 0;
			break;
		case 'E':
			d = 1;
			break;
		case 'S':
			d = 2;
			break;
		case 'W':
			d = 3;
		}
	}
};

const int dir[4][2] = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

int a, b, n, m, x, y;
char d;
bool crash = false;
Robot r[101];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> a >> b >> n >> m;

	for (int i = 1; i <= n; i++) {
		cin >> x >> y >> d;
		r[i].setPos(x, y, d);
	}

	while (m--) {
		int robot, k;

		cin >> robot >> d >> k;

		if (crash) continue;
		while (k--) {
			if (d == 'L') {
				if (r[robot].d == 0)
					r[robot].d = 3;
				else r[robot].d--;
			}
			else if (d == 'R') {
				if (r[robot].d == 3)
					r[robot].d = 0;
				else r[robot].d++;
			}
			else if (d == 'F') {
				int nextX = r[robot].x + dir[r[robot].d][0];
				int nextY = r[robot].y + dir[r[robot].d][1];

				if (nextX<1 || nextX>a || nextY<1 || nextY>b) {
					crash = true;
					cout << "Robot " << robot << " crashes into the wall" << '\n';
					break;
				}
				else {
					for (int i = 1; i <= n; i++) {
						if (i == robot) continue;

						if (r[i].x == nextX && r[i].y == nextY) {
							crash = true;
							cout << "Robot " << robot << " crashes into robot " << i << '\n';
							break;
						}
					}
				}

				if (crash) break;
				else {
					r[robot].x = nextX;
					r[robot].y = nextY;
				}
			}
		}
	}

	if (!crash)
		cout << "OK\n";

	return 0;
}