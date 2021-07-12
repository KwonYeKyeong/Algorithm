#include <iostream>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	string a, b;
	int d, min = 51, cnt;

	cin >> a >> b;

	d = b.length() - a.length();

	for (int i = 0; i <= d; i++) {
		string x = a;
		int k = i;
		while (k--) 
			x = b[k] + x;
		k = d - i;
		while (k--)
			x = x + b[(b.length() - 1) - k];
		
		cnt = 0;
		for (int i = 0; i < b.length(); i++) {
			if (x[i] != b[i])
				cnt++;
		}
		min = (min > cnt ? cnt : min);
	}

	cout << min;

	return 0;
}