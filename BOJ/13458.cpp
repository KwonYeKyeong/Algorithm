#include <iostream>
#include <vector>
using namespace std;

int main() {
	int n, k, b, c;
	long long sum = 0;
	vector <int> a;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> k;
		a.push_back(k);
	}
	cin >> b >> c;

	for (int i = 0; i < n; i++) {
		if (a.at(i) < b) {
			sum += 1;
			continue;
		}
		if ((a.at(i) - b) % c == 0)
			sum += (a.at(i) - b) / c + 1;
		else
			sum += (a.at(i) - b) / c + 2;
	}
	cout << sum;
	return 0;
}