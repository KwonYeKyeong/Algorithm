#include <iostream>
using namespace std;

int main() {
	int a, b, v; // +a, -b, v미터 나무
	int up;

	cin >> a >> b >> v;
	up = a - b;

	if ((v - a) % up == 0)
		cout << (v - a) / up + 1;
	else cout << (v - a) / up + 2;	

	return 0;
}