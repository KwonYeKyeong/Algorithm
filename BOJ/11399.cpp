#include <iostream>
using namespace std;

int time[1001];
int sum[1001];

void bubble_sort(int n) {
	for (int i = 1; i < n; i++) {
		for (int j = 1; j < n - i + 1; j++) {
			if (time[j] > time[j + 1]) {
				time[0] = time[j];
				time[j] = time[j + 1];
				time[j + 1] = time[0];
			}
		}
	}
}

int main() {
	int n;
	int result = 0;
	cin >> n;

	for (int i = 1; i <= n; i++)
		cin >> time[i];

	bubble_sort(n);

	sum[1] = time[1];
	result += sum[1];
	for (int i = 1; i < n; i++) {
		sum[i + 1] = sum[i] + time[i + 1];
		result += sum[i + 1];
	}
	cout << result;
	return 0;
}