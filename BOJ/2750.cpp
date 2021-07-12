#include <iostream>
using namespace std;

int arr[1001];

void selection_sort(int n) {
	int min, idx;
	for (int i = 1; i < n; i++) {
		min = arr[i];
		idx = i;
		for (int j = i + 1; j <= n; j++) {
			if (min > arr[j]) {
				min = arr[j];
				idx = j;
			}
		}
		if (idx != i) {
			arr[0] = arr[i];
			arr[i] = min;
			arr[idx] = arr[0];
		}
	}
}
void bubble_sort(int n) {
	for (int i = 1; i < n; i++) {
		for (int j = 1; j < n - i + 1; j++) {
			if (arr[j] > arr[j + 1]) {
				arr[0] = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = arr[0];
			}
		}
	}
}

int main() {
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> arr[i];

	// selection_sort(n);
	bubble_sort(n);

	for (int i = 1; i <= n; i++)
		cout << arr[i] << '\n';
	return 0;
}