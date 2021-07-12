#include <iostream>
#include <queue>
#include <functional>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	priority_queue<int, vector<int>, greater<int>> pq;
	int n, k;

	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> k;
			pq.push(k);
			
			if (pq.size() > n)
				pq.pop();
		}
	}

	cout << pq.top();
	
	return 0;
}