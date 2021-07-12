#include <iostream>
using namespace std;

int n, m;
int num[9], result[9];
bool used[9];

void DFS(int p) { // p: result의 index
	if (p == m) {
		for (int i = 0; i < m; i++)
			cout << result[i] << ' ';
		cout << '\n';
		return;
	}
	for (int i = 0; i < n; i++) {
		if (used[i] == false) {
			result[p] = num[i];
			used[i] = true;
			DFS(p + 1);
			used[i] = false;
		}
	}
	
}

int main() {
	cin >> n >> m;

	for (int i = 0; i < n; i++)
		num[i] = i + 1;

	DFS(0);

	return 0;
}