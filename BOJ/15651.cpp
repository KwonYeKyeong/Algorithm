#include <iostream>
using namespace std;

int n, m, num[8], result[8];

void back_tracking(int k) {
	if (k == m) {
		for (int i = 0; i < m; i++)
			cout << result[i] << ' ';
		cout << '\n';
		return;
	}

	for (int i = 0; i < n; i++) {
		result[k] = num[i];
		back_tracking(k + 1);
	}
}

int main() {
	cin >> n >> m;
	for (int i = 0; i < n; i++)
		num[i] = i + 1;

	back_tracking(0);
	return 0;
}