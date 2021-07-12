#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	vector<int> vec;
	int sum = 0;
	bool check = false;

	for (int i = 0; i < 9; i++) {
		int n;
		cin >> n;
		vec.push_back(n);
	}

	for (auto a : vec)
		sum += a;

	sum -= 100;

	for (int j = 0; j < vec.size();j++) {
		for (int m = j + 1; m < vec.size(); m++) {
			if (vec[j] + vec[m] == sum) {
				vec[j] = -1;
				vec[m] = -1;
				check = true;
				break;
			}
			if (check == true)
				break;
		}
	}

	sort(vec.begin(), vec.end());

	for (int k = 2; k < vec.size(); k++)
		cout << vec[k] << '\n';

	return 0;
}