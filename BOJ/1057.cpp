#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	int n, k, l, result = 1;
	cin >> n >> k >> l;

	while (1) {
		if ((k - l == 1 && k % 2 == 0)
			|| (l - k == 1 && l % 2 == 0)) break;
		
		if (n % 2 == 0) 
			n /= 2;
		else n = n / 2 + 1;

		if (k % 2) 
			k = k / 2 + 1;
		else k /= 2;

		if (l % 2) 
			l = l / 2 + 1;
		else l /= 2;
		
		if (n == 0) {
			result = -1;
			break;
		}
		else result++;
	}

	cout << result;

	return 0;
}