#include <iostream>
#include <cmath>
using namespace std;

int arr[1025];
int tree[11][513];

int main() {
	int K;
	cin >> K;

	for (int i = 1; i <= pow(2, K) - 1; i++)
		cin >> arr[i];
	return 0;
}