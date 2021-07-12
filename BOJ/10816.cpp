#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> card;

void quick_sort(int s, int e) {
	if (s >= e) return;

	int pivot = s;
	int i = s + 1;
	int j = e;
	int temp;

	while (i <= j) {
		while (i <= e && card[pivot] >= card[i])
			i++;
		while (j > s && card[pivot] <= card[j])
			j--;

		if (i > j) {
			temp = card[pivot];
			card[pivot] = card[j];
			card[j] = temp;
		}
		else {
			temp = card[i];
			card[i] = card[j];
			card[j] = temp;
		}
	}
	quick_sort(s, j - 1);
	quick_sort(j + 1, e);
}
int upper_binary(int target, int size) {
	int mid, start = 0, end = size - 1;

	while (end > start) {
		mid = (start + end) / 2;
		if (card[mid] > target)
			end = mid;
		else start = mid + 1;
	}
	return end;
}
int lower_binary(int target, int size) {
	int mid, start = 0, end = size - 1;

	while (end > start) {
		mid = (start + end) / 2;
		if (card[mid] >= target)
			end = mid;
		else start = mid + 1;
	}
	return end;
}


int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int n, m, k, u, l;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> k;
		card.push_back(k);
	}

	sort(card.begin(), card.end());
	//quick_sort(0, n - 1);

	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> k;

		u = upper_binary(k, n);
		l = lower_binary(k, n);
		if (u == n - 1 && card[u] == k)
			u++;

		cout << u - l << ' ';
	}
	return 0;
}