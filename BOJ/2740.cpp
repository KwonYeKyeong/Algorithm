#include <iostream>
#include <vector>
using namespace std;

int matrixA[10001];
int matrixB[10001];
int matrixResult[10001];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	int n, m, k, r = 0, temp;;
	vector<int> vec;

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			cin >> matrixA[m * i + j];
	}
	
	cin >> m >> k;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < k; j++)
			cin >> matrixB[k*i + j];
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < k; j++) {
			for (int t = 0; t < m; t++) 
				vec.push_back(matrixA[m*i + t] * matrixB[k*t + j]);
			for (int v : vec)
				matrixResult[r] += v;
			vec.clear();
			r++;
		}
	}

	for (int i = 0; i < r; i++) {
		cout << matrixResult[i] << ' ';
		if (i%k == k - 1)
			cout << '\n';
	}

	return 0;
}