#include <iostream>
using namespace std;

const int N = 16769023;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	int n, r, result = 1;

	cin >> n;

	if (n % 2) 
		r = (n + 1) / 2;
	else r = n / 2;

	while (r--) 
		result = (result * 2) % N;
	
	cout << result;

	return 0;
}