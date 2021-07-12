#include <iostream>
#include <cmath>
using namespace std;

int main() {
	int t, a, b, c, d, r1, r2, r;
	double distance;
	cin >> t;
	while (t--) {
		cin >> a >> b >> r1 >> c >> d >> r2;
		distance = sqrt(pow(a - c, 2) + pow(b - d, 2));
		r = abs(r1 - r2);

		if (a == c && b == d && r1 == r2)
			cout << -1 << '\n';
		else if (distance > r1 + r2 || r > distance)
			cout << 0 << '\n';
		else if (distance == r || distance == r1 + r2)
			cout << 1 << '\n';
		else if (r1 + r2 > distance)
			cout << 2 << "\n";
	}
	return 0;
}