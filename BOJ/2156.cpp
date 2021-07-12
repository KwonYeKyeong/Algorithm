#include <iostream>
using namespace std;

int n, wine[10001], temp[10001];

void DP(int idx, int check) {
	if (idx > n) return;

	if (check == 0 || check == 1) {
		temp[idx] = temp[idx - 1] + wine[idx];
		DP(idx + 1, check + 1);
	}
	else if (check == 2) {
		temp[idx] = temp[idx - 3] + wine[idx - 1] + wine[idx];
		if (temp[idx] > temp[idx - 1]) {
			if (temp[idx] > temp[idx - 2] + wine[idx])
				DP(idx + 1, check);
			else {
				temp[idx] = temp[idx - 2] + wine[idx];
				DP(idx + 1, 1);
			}
		}
		else {
			if (temp[idx - 1] >= temp[idx - 2] + wine[idx]) {
				temp[idx] = temp[idx - 1];
				DP(idx + 1, 0);
			}
			else {
				temp[idx] = temp[idx - 2] + wine[idx];
				DP(idx + 1, 1);
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	
	cin >> n;
	for (int i = 1; i <= n; i++) 
		cin >> wine[i];
	
	DP(1, 0);

	cout << temp[n];

	return 0;
}