#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	int n, k, num[2000001] = {};

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> k;
		num[k + 1000000]++;
	}

	for (int i = 0; i < 2000001; i++) {
		while (num[i]--)
			cout << i - 1000000 << '\n';
	}

	return 0;
}