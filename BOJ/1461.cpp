#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>
using namespace std;

int n, m, k, MAX, res;
vector<int> pbooks, nbooks;

bool compare(int a, int b) {
	return a > b;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> n >> m;
	while (n--) {
		cin >> k;
		if (k > 0) {
			pbooks.push_back(k);
			if (abs(MAX) < k)
				MAX = k;
		}
		else { 
			nbooks.push_back(abs(k)); 
			if (abs(MAX) < abs(k))
				MAX = k;
		}
	}

	sort(pbooks.begin(), pbooks.end(), compare);
	sort(nbooks.begin(), nbooks.end(), compare);
	
	int idx = 0;
	while (idx < pbooks.size()) {
		if (idx == 0 && MAX > 0)
			res += pbooks[idx];
		else 
			res += 2 * pbooks[idx];
		idx += m;
	}
	idx = 0;
	while (idx < nbooks.size()) {
		if (idx == 0 && MAX < 0)
			res += nbooks[idx];
		else
			res += 2 * nbooks[idx];
		idx += m;
	}

	cout << res;

	return 0;
}