#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;

	for (int line = 1; line <= n; line++)
	{
		for (int space = 1; space <= n - line; space++)
			cout << " ";
		for (int star = 1; star <= line; star++)
			cout << "*";
		cout << endl;
	}
	return 0;
}