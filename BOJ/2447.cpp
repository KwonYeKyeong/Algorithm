#include <iostream>
#include <cstring>
using namespace std;

char map[2300][2300];

void solve(int n, int x, int y) {
	if (n == 1) {
		map[x][y] = '*';
		return;
	}

	int div = n / 3;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (i == 1 && j == 1) continue;
			else solve(div, (div*i) + x, (div*j) + y);
		}
	}
}

int main() {
	ios::sync_with_stdio(0);

	int n;
	cin >> n;

	memset(map, ' ', sizeof(map));

	solve(n, 0, 0);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			cout << map[i][j];
		cout << endl;
	}
	
	return 0;
}