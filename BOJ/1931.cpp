#include <iostream>
#include <algorithm>
using namespace std;

struct Meeting {
	int s, e;
	void setTime(int ss, int ee) {
		s = ss;
		e = ee;
	}
};

int n, a, b, cnt;
Meeting m[100001];

bool compare(Meeting m1, Meeting m2) {
	if (m1.e == m2.e)
		return m1.s < m2.s;
	return m1.e < m2.e;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		m[i].setTime(a, b);
	}

	sort(m, m + n, compare);

	int cur = 0;
	for (int i = 0; i < n; i++) {
		if (cur <= m[i].s) {
			cnt++;
			cur = m[i].e;
		}
	}

	cout << cnt;

	return 0;
}