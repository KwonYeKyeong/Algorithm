#include <iostream>
using namespace std;

#define MAX 1000000001

int n, num[11];
int maxx = -MAX;
int minn = MAX;

void DFS(int k, int oper[], int result) {
	if (k == n) {
		maxx = (maxx < result ? result : maxx);
		minn = (minn > result ? result : minn);
	}
	else {
		if (oper[0] > 0) {
			oper[0]--;
			DFS(k + 1, oper, result + num[k]);
			oper[0]++;
		}
		if (oper[1] > 0) {
			oper[1]--;
			DFS(k + 1, oper, result - num[k]);
			oper[1]++;
		}
		if (oper[2] > 0) {
			oper[2]--;
			DFS(k + 1, oper, result * num[k]);
			oper[2]++;
		}
		if (oper[3] > 0) {
			oper[3]--;
			DFS(k + 1, oper, result / num[k]);
			oper[3]++;
		}
	}
}

int main() {
	int oper[4] = {};

	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> num[i];
	for (int i = 0; i < 4; i++)
		cin >> oper[i];

	DFS(1, oper, num[0]);

	cout << maxx << '\n' << minn << '\n';

	return 0;
}