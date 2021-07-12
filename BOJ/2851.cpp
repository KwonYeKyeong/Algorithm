#include <iostream>
using namespace std;

int main() {
	int mushroom[10];
	int sum[10];

	for (int i = 0; i < 10; i++)
		cin >> mushroom[i];

	sum[0] = mushroom[0];
	for (int j = 1; j < 10; j++) 
		sum[j] = sum[j - 1] + mushroom[j];
	
	int min = 100 - sum[0];
	int idx = 0;
	for (int k = 1; k < 10; k++) {
		if (sum[k] <= 100) {
			idx = (min < (100 - sum[k]) ? idx : k);
			min = (min < (100 - sum[k]) ? min : 100 - sum[k]);
		}
		else {
			idx = (min < (sum[k] - 100) ? idx : k);
			min = (min < (sum[k] - 100) ? min : sum[k] - 100);
			break;
		}
	}
	cout << sum[idx];
	return 0;
}