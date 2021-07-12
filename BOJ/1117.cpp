#include <iostream>
using namespace std;

long long w, h, f, c, X1, X2, Y1, Y2, L, R, res;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> w >> h >> f >> c >> X1 >> Y1 >> X2 >> Y2;

	if (f < (w - f)) {
		if (f <= X1)
			L = 0;
		else if (f <= X2)
			L = (f - X1)*(Y2 - Y1);
		else
			L = (X2 - X1)*(Y2 - Y1);

		R = (X2 - X1)*(Y2 - Y1);
	}
	else {
		L = (X2 - X1)*(Y2 - Y1);

		if (X1 >= (w - f))
			R = 0;
		else if (X2 > (w - f))
			R = (w - f - X1)*(Y2 - Y1);
		else R = (X2 - X1)*(Y2 - Y1);
	}
	
	res = w*h - (L + R)*(c + 1);
	cout << res;

	return 0;
}