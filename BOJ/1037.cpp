#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	int n, num[51];
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> num[i];
	sort(num, num + n);
	cout << num[0] * num[n - 1];
	return 0;
}