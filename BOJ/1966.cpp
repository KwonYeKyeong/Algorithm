#include <iostream>
#include <queue>
#include <vector>
using namespace std;

struct Int {
	int a, b;
};

int max(vector<int>& v) {
	int value = v[0];
	for (auto x : v) {
		if (value < x)
			value = x;
	}
	return value;
}

int maxIndex(vector<int>& v) {
	int idx = 0;
	int value = max(v);
	for (int i=0;i<v.size();i++){
		if (value == v[i]) {
			idx = i;
			break;
		}
	}
	return idx;
}

int main() {
	int test; // test case의 수
	int N, M; // 문서의 수, 궁금한 문서의 현재위치

	cin >> test;

	for (int i = 0; i < test; i++) {
		 queue<Int> q;
		vector<int> vec;
		int count = 0;

		cin >> N >> M;
		for (int j = 0; j < N; j++) {
			int temp;
			cin >> temp;
			q.push({ j, temp });
			vec.push_back(temp);
		}
		while (1) {
			int index = q.front().a;
			int importance = q.front().b;
			q.pop();
			int max_data = max(vec);
			int max_index = maxIndex(vec);
			if (importance == max_data) {
				vec.erase(vec.begin()+max_index);
				count++;
				if (index == M) break;
			}
			else {
				q.push({ index, importance });
			}
		}
		cout << count << "\n";
	}
	return 0;
}
