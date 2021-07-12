/*
#include <iostream>
using namespace std;

int n, s = 500001, A[51], B[51], visited[51];

void solve(int idx, int* v, int ss, int cnt) {
	ss += A[idx] * B[cnt];
	v[idx] = 1;

	if (cnt == n - 1) {
		s = s > ss ? ss : s;
		return;
	}

	for (int i = 0; i < n; i++) {
		if (!v[i]) {
			solve(i, v, ss, cnt + 1);
			v[i] = 0;
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> A[i];
	for (int i = 0; i < n; i++)
		cin >> B[i];

	for (int i = 0; i < n; i++)
		solve(i, visited, 0, 0);

	cout << s;

	return 0;
}
*/

#include <iostream>
#include <algorithm>
using namespace std;

bool compare(int a, int b) {
	return b < a;
}

int main() {
	int n, s = 0, A[51], B[51];
	
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> A[i];
	for (int i = 0; i < n; i++)
		cin >> B[i];

	sort(A, A + n);
	sort(B, B + n, compare);

	for (int i = 0; i < n; i++)
		s += A[i] * B[i];

	cout << s;

	return 0;
}