#include <iostream>
#include <algorithm>
using namespace std;

const int INF = 987654321;

int n, s, N[100001], len, startIdx, endIdx, sum;

bool over(int i) {
	if (0 <= i && i < n)
		return false;
	return true;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);;

	len = INF;

	cin >> n >> s;
	for (int i = 0; i < n; i++) 
		cin >> N[i];
	
	startIdx = endIdx = 0;
	sum = N[0];
	while (!over(startIdx) && !over(endIdx)) {
		if (sum < s) {
			endIdx++;
			sum += N[endIdx];
		}
		else {
			len = min(len, endIdx - startIdx + 1);
			sum -= N[startIdx];
			startIdx++;
		}
	}

	if (len == INF) len = 0;
	cout << len;

	return 0;
}