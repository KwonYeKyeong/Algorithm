#include <iostream>
#include <algorithm>
using namespace std;

int n, m;
long long card[1001], result = 0;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++)
		cin >> card[i];

	for (int i = 0; i < m; i++) {
		sort(card, card + n);
		long long a = card[0];
		long long b = card[1];
		card[0] += b;
		card[1] += a;
	}

	for (long long c : card)
		result += c;

	cout << result;

	return 0;
}

/* priority queue ver.
#include <iostream>
#include <queue>
#include <functional>
using namespace std;

int n, m;
long long k, result = 0;
priority_queue<long long, vector<long long>, greater<long long>> pq;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> k;
		pq.push(k);
	}

	for (int i = 0; i < m; i++) {
		long long a = pq.top();
		pq.pop();
		long long b = pq.top();
		pq.pop();
		pq.push(a + b);
		pq.push(a + b);
	}

	while (!pq.empty()) {
		k = pq.top();
		pq.pop();
		result += k;
	}

	cout << result;
	
	return 0;
}
*/