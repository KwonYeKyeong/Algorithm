#include <iostream>
using namespace std;

int main() {
	int m, n, minNum = -1, sum = 0;
	bool check;
	cin >> m >> n;
	for (int i = m; i <= n; i++) {
		check = false;
		for (int j = 2; j < i; j++) {
			if (i%j == 0) check = true;
		}
		if (!check && i != 1) {
			if (minNum == -1) minNum = i;
			sum += i;
		}
	}
	if (sum == 0) cout << -1;
	else cout << sum << '\n' << minNum;
	return 0;
}