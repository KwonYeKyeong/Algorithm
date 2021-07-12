#include <iostream>
using namespace std;

int main() {
	int num, count = 99;

	cin >> num;

	if (num < 100)
		cout << num;
	else {
		for (int i = 111; i <= num; i++) {
			int a = i / 100;
			int b = (i % 100) / 10;
			int c = i % 10;
			if ((a - b) == (b - c)) count++;
		}
		cout << count;
	}
	
	return 0;
}