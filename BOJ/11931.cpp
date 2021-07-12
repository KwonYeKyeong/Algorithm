#include <iostream>
using namespace std;

int n, num[1000001], result[1000001], idx;
int negativeCnt[1000001], positiveCnt[1000001];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> num[i];
		if (num[i] < 0)
			negativeCnt[(-1)*num[i]]++;
		else
			positiveCnt[num[i]]++;
	}

	for (int i = 999999; i >= 0; i--) 
		positiveCnt[i] += positiveCnt[i + 1];
	negativeCnt[0] = positiveCnt[0];
	for (int i = 1; i <= 1000000; i++) {
		negativeCnt[i] += negativeCnt[i - 1];
	}

	for (int i = 0; i < n; i++) {
		if (num[i] < 0) {
			idx = negativeCnt[(-1)*num[i]];
			result[idx] = num[i];
			negativeCnt[(-1)*num[i]]--;
		}
		else {
			idx = positiveCnt[num[i]];
			result[idx] = num[i];
			positiveCnt[num[i]]--;
		}
	}

	for (int i = 1; i <= n; i++)
		cout << result[i] << '\n';

	return 0;
}