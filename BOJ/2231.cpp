#include <iostream>
using namespace std;
/*
int main() {
	int n, m = 1, result = 0;
	int N[7] = {};
	cin >> n;

	while (m < n) {
		if (m < 10) {
			if (2 * m == n) {
				result = m;
				break;
			}
			else m++;
		}
		else if (m < 100) {
			N[0] = m / 10;
			N[1] = m % 10;
			if (m + N[0] + N[1] == n) {
				result = m;
				break;
			}
			else m++;
		}
		else if (m < 1000) {
			N[0] = m / 100;
			N[1] = (m / 10) % 10;
			N[2] = m % 10;
			if (m + N[0] + N[1] + N[2] == n) {
				result = m;
				break;
			}
			else m++;
		}
		else if (m < 10000) {
			N[0] = m / 1000;
			N[1] = (m / 100) % 10;
			N[2] = (m / 10) % 10;
			N[3] = m % 10;
			if (m + N[0] + N[1] + N[2] + N[3] == n) {
				result = m;
				break;
			}
			else m++;
		}
		else if (m < 100000) {
			N[0] = m / 10000;
			N[1] = (m / 1000) % 10;
			N[2] = (m / 100) % 10;
			N[3] = (m / 10) % 10;
			N[4] = m % 10;
			if (m + N[0] + N[1] + N[2] + N[3] + N[4] == n) {
				result = m;
				break;
			}
			else m++;
		}
		else if (m < 1000000) {
			N[0] = m / 100000;
			N[1] = (m / 10000) % 10;
			N[2] = (m / 1000) % 10;
			N[3] = (m / 100) % 10;
			N[4] = (m / 10) % 10;
			N[5] = m % 10;
			if (m + N[0] + N[1] + N[2] + N[3] 
				+ N[4] + N[5] == n) {
				result = m;
				break;
			}
			else m++;
		}
	}
	cout << result;
	return 0;
}
*/

int main() {
	int n, copy, sum, creater = 1, result = 0;
	cin >> n;

	while (creater < n) {
		sum = creater;
		copy = creater;
		while (copy) {
			sum += copy % 10;
			copy /= 10;
		}
		if (sum == n) {
			result = creater;
			break;
		}
		else creater++;
	}
	
	cout << result;

	return 0;
}
