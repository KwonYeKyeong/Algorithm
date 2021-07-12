#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	string gear[5];
	int k, m, n, rotation[5], point[8] = {}, sum = 0;

	for (int i = 1; i <= 4; i++)
		cin >> gear[i];
	cin >> k;
	while (k--) {
		cin >> m >> n;
		rotation[m] = n;
		for (int i = m; i <= 3; i++) {
			int x = (point[i] + 2) % 8;
			int y = (point[i + 1] + 6) % 8;
			if (gear[i][x] == gear[i + 1][y])
				rotation[i + 1] = 0;
			else rotation[i + 1] = rotation[i] * (-1);
		}
		for (int i = m; i >= 2; i--) {
			int x = (point[i] + 6) % 8;
			int y = (point[i - 1] + 2) % 8;
			if (gear[i][x] == gear[i - 1][y])
				rotation[i - 1] = 0;
			else rotation[i - 1] = rotation[i] * (-1);
		}

		for (int i = 1; i <= 4; i++) {
			switch (rotation[i])
			{
			case 1:
				point[i] -= 1;
				if (point[i] < 0) point[i] = 7;
				break;
			case -1:
				point[i] = (point[i] + 1) % 8;
				break;
			case 0:
				break;
			default:
				break;
			}
		}
	}

	for (int i = 1; i <= 4; i++) {
		if (gear[i][point[i]] == '1')
			sum += pow(2, i - 1);
	}

	cout << sum;

	return 0;
}