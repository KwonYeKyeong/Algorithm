#include <iostream>
using namespace std;

int rankk[51] = {};
pair<int, int> info[51];

int main() {
	int n;

	cin >> n;
	for (int i = 0; i < n; i++) 
		cin >> info[i].first >> info[i].second;
	
	for (int i = 0; i < n; i++) {
		rankk[i]++;
		for (int j = 0; j < n; j++) {
			if (info[i].first > info[j].first && info[i].second > info[j].second)
				rankk[j]++;
		}
	}
	
	for (int i = 0; i < n; i++)
		cout << rankk[i] << ' ';
	return 0;
}