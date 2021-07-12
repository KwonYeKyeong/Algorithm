#include <iostream>
#include <vector>
using namespace std;
/*
// º¤ÅÍ »ç¿ë

int k;
vector<int> vec(13), result;

void DFS(int i, vector<int> result) {
	if (result.size() == 6) {
		for (int a : result)
			cout << a << ' ';
		cout << '\n';
		return;
	}
	if (i >= k) return;
	result.push_back(vec[i]);
	DFS(i + 1, result);
	result.pop_back();
	DFS(i + 1, result);
}

int main() {
	int s;
	while (cin >> k) {
		if (k == 0) break;

		for (int i = 0; i < k; i++) 
			cin >> vec[i];

		DFS(0, result);
		cout << '\n';
	}
	return 0;
}
*/

// º¤ÅÍ »ç¿ë X

int k, S[13], result[7];

void DFS(int n, int m) {
	if (m == 6) {
		for (int i = 0; i < 6; i++)
			cout << result[i] << ' ';
		cout << '\n';
		return;
	}
	for (int i = n; i < k; i++) {
		result[m] = S[i];
		DFS(i + 1, m + 1);
	}
}
int main() {
	while (cin >> k) {
		if (k == 0) break;

		for (int i = 0; i < k; i++)
			cin >> S[i];

		DFS(0, 0);
		cout << '\n';
	}
	return 0;
}