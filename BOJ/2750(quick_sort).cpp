#include <iostream>
using namespace std;

void quick_sort(int data[], int s, int e) { // s = start, e = end
	if (s >= e) {
		// 원소의 개수가 1개일 때
		return;
	}

	int pivot = s;
	int i = s + 1;
	int j = e;
	int temp;

	while (i <= j) {
		while (i <= e && data[pivot] >= data[i]) {
			// 피벗보다 큰 값 찾기
			i++;
		} 
		while (j > s && data[pivot] <= data[j]) {
			// 피벗보다 작은 값 찾기
			j--; 
		}
		
		if (i > j) {
			// 엇갈림
			temp = data[j];
			data[j] = data[pivot];
			data[pivot] = temp;
		}
		else {
			// i번째와  j번째를 스왑
			temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
	}

	// 분할 계산
	quick_sort(data, s, j - 1);
	quick_sort(data, j + 1, e);
}

int main() {
	int data[10000];
	int n;
	cin >> n;

	for (int i = 0; i < n; i++)
		cin >> data[i];

	quick_sort(data, 0, n - 1);

	for (int i = 0; i < n; i++)
		cout << data[i] << '\n';

	return 0;
}