#include <iostream>
using namespace std;

int table[1501][1501], ptr[1501];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, max, maxIdx, cnt = 0, result;
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			cin >> table[i][j];
		ptr[i] = n - 1;
	}

	while (true) {
		max = table[ptr[0]][0];
		maxIdx = 0;
		for (int i = 1; i < n; i++) {
			if (max < table[ptr[i]][i]) {
				max = table[ptr[i]][i];
				maxIdx = i;
			}
		}
		if (++cnt == n) {
			result = max;
			break;
		}
		ptr[maxIdx]--;
	}

	cout << result;

	return 0;
}