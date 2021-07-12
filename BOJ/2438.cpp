#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;

	for (int line = 1; line <= n; line++)
	{
		for (int space = 1; space < line; space++)
			cout << " ";
		for (int star = 1; star <= n - line + 1; star++)
			cout << "*";
		cout << endl;
	}
	return 0;
}