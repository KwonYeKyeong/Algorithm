#include <iostream>
#include <cstdlib>
#include <vector>
using namespace std;

int n, board[21][21], start_sum, link_sum, minn = 101;
vector<int> start, link;

void DFS(int idx) {
	if (idx == n) {
		if (start.size() == n / 2
			&& link.size() == n / 2) {
			start_sum = link_sum = 0;
			for (int i = 0; i < n / 2; i++) {
				for (int j = i + 1; j < n / 2; j++) {
					start_sum += board[start[i]][start[j]] + board[start[j]][start[i]];
					link_sum += board[link[i]][link[j]] + board[link[j]][link[i]];
				}
			}
			minn = (minn > abs(start_sum - link_sum) ? abs(start_sum - link_sum) : minn);
		}
		return;
	}
	start.push_back(idx);
	DFS(idx + 1);
	start.pop_back();

	link.push_back(idx);
	DFS(idx + 1);
	link.pop_back();
}

int main() {
	ios::sync_with_stdio(0);

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			cin >> board[i][j];
	}

	DFS(0);

	cout << minn;

	return 0;
}
