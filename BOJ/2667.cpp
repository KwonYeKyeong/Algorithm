#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int dx[4] = { 0,-1,0,1 };
int dy[4] = { -1,0,1,0 };

int s, cnt;
string board[26];
bool visited[26][26];
vector<int> vec;

bool out(int x, int y) {
	if (x < 0 || x >= s || y < 0 || y >= s)
		return true;
	return false;
}
void dfs(int x, int y) {
	visited[x][y] = true;
	cnt++;
	for (int i = 0; i < 4; i++) {
		int nextX = x + dx[i];
		int nextY = y + dy[i];
		if (!out(nextX, nextY)) {
			if(board[nextX][nextY] == '1' && !visited[nextX][nextY])
				dfs(nextX, nextY);
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	
	cin >> s;
	for (int i = 0; i < s; i++)
		cin >> board[i];

	for (int i = 0; i < s; i++) {
		for (int j = 0; j < s; j++) {
			if (board[i][j] == '1' && !visited[i][j]) {
				cnt = 0;
				dfs(i, j);
				vec.push_back(cnt);
			}
		}
	}
	sort(vec.begin(), vec.end());

	cout << vec.size() << '\n';
	for (int v : vec)
		cout << v << '\n';
}