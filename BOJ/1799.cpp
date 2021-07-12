#include <iostream>
using namespace std;

// 체스판을 2가지(B, W)로 나누어 푸는 것이 핵심방법
#define B 0
#define W 1

int board[11][11], l[20], r[20];
int s, black, white;

void back_tracking(int x, int y, int cnt, int color) {
	if (y >= s) {
		x++;
		if (y % 2) y = 0;
		else y = 1;
	}

	if (x >= s) {
		if (color == W)
			white = white < cnt ? cnt : white;
		else
			black = black < cnt ? cnt : black;
		return;
	}

	/*
	현재 위치에 비숍을 놓을 수 있는 지를 판단하기 위해 3가지 조건
	1. chess판에 비숍을 놓을 수 있는가.
	2. 왼쪽 대각선 방향에 비숍이 놓여져 있는가.
	3. 오른쪽 대각선 방향에 비숍이 놓여져 있는가.
	*/
	if (board[x][y] && !l[y - x + s - 1] && !r[x + y]) {
		l[y - x + s - 1] = r[x + y] = 1;
		back_tracking(x, y + 2, cnt + 1, color);
		l[y - x + s - 1] = r[x + y] = 0;
	}
	back_tracking(x, y + 2, cnt, color);
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> s;
	for (int i = 0; i < s; i++) {
		for (int j = 0; j < s; j++)
			cin >> board[i][j];
	}

	back_tracking(0, 0, 0, B);
	back_tracking(0, 1, 0, W);

	cout << black + white;

	return 0;
}