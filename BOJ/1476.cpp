#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	int e, s, m, yr = 1, _e = 1, _s = 1, _m = 1;
	cin >> e >> s >> m;
	while (1) {
		if (_e == 16) _e = 1;
		if (_s == 29) _s = 1;
		if (_m == 20) _m = 1;

		if (_e == e && _s == s && _m == m) break;
		else {
			yr++;
			_e++;
			_s++;
			_m++;
		}
	}
	cout << yr;
	return 0;
}