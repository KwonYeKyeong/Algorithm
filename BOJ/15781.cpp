#include <iostream>
using namespace std;

unsigned int maxx(unsigned int a, unsigned int b) {
	return (a < b ? b : a);
}

int main() {
	int n, m;
	unsigned int k, hMax = 0, vMax = 0;

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		cin >> k;
		hMax = maxx(hMax, k);
	}
	for (int i = 0; i < m; i++) {
		cin >> k;
		vMax = maxx(vMax, k);
	}
	cout << hMax + vMax;
	return 0;
}