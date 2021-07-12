#include <iostream>
#include <algorithm>
using namespace std;

int rope[100001];
int weight[100001];

void bubble_sort(int n) {
	for (int i = 1; i < n; i++) {
		for (int j = 1; j < n - i + 1; j++) {
			if (rope[j] > rope[j + 1]) {
				rope[0] = rope[j];
				rope[j] = rope[j + 1];
				rope[j + 1] = rope[0];
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n, k, max;
	cin >> n;
	for (int i = 1; i <= n; i++) 
		cin >> rope[i];

	sort(rope, rope + (n + 1));
	// bubble_sort(n);

	for (int i = 1; i <= n; i++) {
		weight[i] = rope[i] * (n - i + 1);
		if (i == 1)
			max = weight[i];
		else
			max = (max > weight[i] ? max : weight[i]);
	}

	cout << max;
	return 0;
}