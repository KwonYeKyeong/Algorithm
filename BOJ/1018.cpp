#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

int main() {
	int N, M;
	int result = 64;
	cin >> N >> M;

	vector<string> chess(50);
	char a;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> a;
			chess[i].push_back(a);
		}
	}

	for (int k = 0; k < N - 7; k++) {
		for (int s = 0; s < M - 7; s++) {
			int count = 0;
			for (int y = 0; y < 8; y++) {
				for (int x = 0; x < 8; x++) {
					if ((y % 2 != x % 2) && chess[k + y][s + x] == 'W')
						count++;
					if ((y % 2 == x % 2) && chess[k + y][s + x] == 'B')
						count++;
				}
			}
			result = min(result, count);
			result = min(result, 64 - count);
		}
	}

	cout << result;

	return 0;
}