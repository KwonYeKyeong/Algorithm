#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int result[1000001];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	int n, k;
	stack<int> num, st;
	vector<int> vec;
	bool check = false;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> k;
		num.push(k);
	}

	for (int i = n; i > 0; i--) {
		check = false;

		if (st.empty())
			result[i] = -1;
		else {
			while (!st.empty()) {
				if (st.top() > num.top()) {
					result[i] = st.top();
					check = true;
					break;
				}
				else
					st.pop();
			}
			if (!check)
				result[i] = -1;
		}

		k = num.top();
		num.pop();
		if (!num.empty() && k > num.top())
			st.push(k);
	}

	for (int i = 1; i <= n; i++)
		cout << result[i] << ' ';

	return 0;
}