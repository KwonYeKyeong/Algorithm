#include <iostream>
using namespace std;

int n, result;
int map[15];

bool pos(int k) {
	for (int i = 0; i < k; i++) {
		if (map[i] == map[k] || abs(map[k] - map[i]) == k - i)
			// 같은 행에 있거나 대각선에 위치해 있는 경우
			return false;
	}
	return true;
}
void N_Queen(int k) {
	if (k == n)
		result++;
	else {
		for (int i = 0; i < n; i++) {
			map[k] = i;
			if (pos(k))
				N_Queen(k + 1);
		}
	}
}
int main() {
	cin >> n;

	N_Queen(0);

	cout << result;
	return 0;
}