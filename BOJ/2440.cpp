#include <iostream>
using namespace std;

int main() {
	int num;

	cin >> num;

	for (int a = num; a >0; a--) {
		for (int b = a; b > 0; b--) {
			cout << "*";
		}
		cout << endl;
	}
	return 0;
}

/*
#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;

	for (int line = 1; line <= n; line++)
	{
		for (int star = 1; star <= n - line + 1; star++)
			cout << "*";
		cout << endl;
	}
	return 0;
}
*/