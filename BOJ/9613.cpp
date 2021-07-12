#include <iostream>
#include <vector>
using namespace std;

int gcd(int a, int b) {
	int temp;
	while (a != b) {
		if (a > b)
			a = a - b;
		else
			b = b - a;
	}
	return a;
}

int main() {
	ios::sync_with_stdio(0);
	int t, n, k;
	
	cin >> t;
	while (t--) {
		vector<int> vec;
		long long sum = 0;

		cin >> n;
		for (int i = 0; i < n; i++) {
			cin >> k;
			vec.push_back(k);
		}

		for (int i = 0; i < vec.size(); i++) {
			for (int j = i + 1; j < vec.size(); j++) {
				sum += gcd(vec[i], vec[j]);
			}
		}

		cout << sum << '\n';
	}
	return 0;
}