#include <iostream>
#include <queue>
#include <utility>
using namespace std;

const int MAX = 100001;
const int INF = 99999999;

int n, k, visited[100001];
queue<pair<int, int>> q;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> n >> k;

	for (int i = 0; i < MAX; i++)
		visited[i] = INF;

	q.push(make_pair(n, 0));
	visited[n] = 1;
	while (!q.empty()) {
		int f = q.front().first;
		int s = q.front().second;

		if (f == k) {
			cout << s;
			break;
		}

		q.pop();

		if (f <= 50000 && visited[f * 2] > s) { // 순간이동 먼저 체크 -> 1 2 답 : 0
			q.push(make_pair(f * 2, s));
			visited[f * 2] = s;
		}
		if (f > 0 && visited[f - 1] > s + 1) {
			q.push(make_pair(f - 1, s + 1));
			visited[f - 1] = s + 1;
		}
		if (f < 100000 && visited[f + 1] > s + 1) {
			q.push(make_pair(f + 1, s + 1));
			visited[f + 1] = s + 1;
		}
	}

	return 0;
}