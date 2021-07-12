#include <iostream>
using namespace std;

int main()
{
	int num;

	cin >> num;

	for (int line = 0; line < num; line++)
	{
		for (int star = 0; star < line + 1; star++)
			cout << '*';
		for (int space = 0; space < 2*(num - line - 1); space++)
			cout << ' ';
		for (int star = 0; star < line + 1; star++)
			cout << '*';
		cout << "\n";
	}
	for (int line = 0; line < num - 1; line++)
	{
		for (int star = 0; star < num - line - 1; star++)
			cout << '*';
		for (int space = 0; space < 2 * (line + 1); space++)
			cout << ' ';
		for (int star = 0; star < num - line - 1; star++)
			cout << '*';
		cout << "\n";
	}
	return 0;
}