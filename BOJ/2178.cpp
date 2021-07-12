#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct Int {
	int a, b;
};

vector<string> map(101);
queue<Int> q;
bool visit[101][101] = {};

int main() {
	int r, c;
	char k;
	cin >> r >> c;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cin >> k;
			map[i].push_back(k);
		}
	}
	return 0;
}