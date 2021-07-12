#include <iostream>
#include <vector>
using namespace std;

int main() {
	std::ios::sync_with_stdio(false);

	int n, k, p = 0;
	int num[10001] = {};

	cin >> n;
	while (n--) {
		cin >> k;
		num[k]++;
	}

	for (int i = 1; i < 10001; i++)
		num[i] += num[i - 1];

	for (int i = 1; i < 10001; i++) {
		while (num[i] > num[i - 1]) {
			cout << i << '\n';
			num[i - 1]++;
		}
	}
	return 0;
}