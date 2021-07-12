#include <iostream>
using namespace std;

int d[10000];

int main() {
	int t, n;
	cin >> t;

	d[1] = 1;
	d[2] = 2;
	d[3] = 4;
	for (int i = 0; i < t; i++) {
		cin >> n;
		for (int j = 4; j <= n; j++) 
			d[j] = d[j - 1] + d[j - 2] + d[j - 3];
		cout << d[n] << '\n';
	}

	return 0;
}