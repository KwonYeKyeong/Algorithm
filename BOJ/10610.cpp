#include <iostream>
#include <string>
using namespace std;

void quick_sort(string& data, int s, int e) {
	if (s >= e)
		return;

	int pivot = s;
	int i = s + 1;
	int j = e;
	int tmp;

	while (i <= j) {
		while (i <= e && data[pivot] <= data[i])
			i++;
		while (j > s && data[pivot] >= data[j])
			j--;
		if (i <= j) {
			tmp = data[i];
			data[i] = data[j];
			data[j] = tmp;
		}
		else {
			tmp = data[pivot];
			data[pivot] = data[j];
			data[j] = tmp;
		}
	}

	quick_sort(data, s, j - 1);
	quick_sort(data, j + 1, e);
}

int main() {
	string s;
	int sum = 0;
	bool zero = false;

	cin >> s;

	for (int i = 0; i < s.length(); i++) {
		if (s[i] - '0' == 0)
			zero = true;
		else
			sum += s[i] - '0';
	}
	if (zero && sum % 3 == 0) {
		quick_sort(s, 0, s.length());
		cout << s;
	}
	else cout << -1;
	return 0;
}
