#include <iostream>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);

	int m, k, BIT = 0;
	string s;

	cin >> m;
	while(m--) {
		cin >> s;
		if (s == "add") {
			cin >> k;

			BIT |= (1 << k); 
		}
		else if (s == "remove") {
			cin >> k;

			BIT &= ~(1 << k);
		}
		else if (s == "check") {
			cin >> k;

			if (BIT & (1 << k))
				cout << 1 << '\n';
			else
				cout << 0 << '\n';
		}
		else if (s == "toggle") {
			cin >> k;

			BIT ^= (1 << k); // ^ : XOR
		}
		else if (s == "all") {
			BIT = (1 << 21) - 1; // ex) 10000 - 1 = 1111
		}
		else if (s == "empty") {
			BIT = 0;
		}
	}

	return 0;
}