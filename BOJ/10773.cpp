#include <iostream>
#include <vector>
using namespace std;

int main() {
	vector<int> vec;
	int k, n;
	int sum = 0;
	cin >> k;

	for (int i = 0; i < k; i++) {
		cin >> n;
		if (n == 0)
			vec.pop_back();
		else
			vec.push_back(n);
	}
	for (int x : vec) 
		sum += x;
	cout << sum;
	return 0;
}