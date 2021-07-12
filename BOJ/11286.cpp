#include <iostream>
#include <vector>
using namespace std;

#define rootIdx 1

class minHeap {
public:
	vector<int> data;
	int heapSize;

	minHeap() {
		data.push_back(-1);
		heapSize = 0;
	}
	void _swap(int idx1, int idx2) {
		data[0] = data[idx1];
		data[idx1] = data[idx2];
		data[idx2] = data[idx1];
	}
	int _abs(int idx) {
		if (data[idx] > 0) return data[idx];
		return (-1)*data[idx];
	}
	bool isEmpty() {
		return heapSize == 0;
	}
	void insert(int e) {
		data.push_back(e);
		heapSize++;

		int idx = heapSize;
		while (idx > rootIdx) {
			if (_abs(idx) == _abs((idx / 2))) {
				if (data[idx] < data[(idx / 2)]) {
					_swap(idx, (idx / 2));
					idx /= 2;
				}
			}
			else if (_abs(idx) < _abs((idx / 2))) {
				_swap(idx, (idx / 2));
				idx /= 2;
			}
			else break;
		}
	}
	void remove() {
		if (!isEmpty()) {
			data[1] = data[heapSize--];
			data.pop_back();

			int idx = rootIdx;
			while (idx * 2 <= heapSize) {
				int left = idx * 2;
				int right = idx * 2 + 1;
				int minIdx;
				if (right <= heapSize) {
					if (_abs(left) < _abs(right))
						minIdx = left;
					else minIdx = right;
				}
				else minIdx = left;

				if (_abs(idx) > _abs(minIdx)) {
					_swap(idx, minIdx);
					idx = minIdx;
				}
				else break;
			}
		}
	}
	int min() {
		if (isEmpty()) return 0;
		else return data[1];
	}
};

int main() {
	minHeap h;

	int n, k;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> k;
		if (k == 0) {
			cout << h.min() << '\n';
			h.remove();
		}
		else h.insert(k);
	}
	return 0;
}