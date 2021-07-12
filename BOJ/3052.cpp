#include <iostream>
using namespace std;

int main() {
	int remainder[42] = {}, k, res = 0;

	for (int i = 0; i < 10; i++) {
		cin >> k;
		remainder[k % 42]++;
	}

	for (int i = 0; i < 42; i++) {
		if (remainder[i])
			res++;
	}

	cout << res;

	return 0;
}