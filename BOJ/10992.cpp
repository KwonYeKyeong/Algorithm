#include <iostream>
using namespace std;

int main()
{
	int num;

	cin >> num;

	for (int line = 0; line < num; line++)
	{
		for (int a = 0; a < num - line - 1; a++)
			cout << ' ';
		if (line != (num - 1))
		{
			cout << '*';
			for (int b = 0; b < 2 * line - 1; b++)
			{
				if (b == 2 * (line - 1))
					cout << " *";
				else
					cout << ' ';
			}
		}
		else if (line == (num - 1))
		{
			for (int star = 0; star < 2 * line + 1; star++)
				cout << '*';
		}
		cout << endl;
	}
	return 0;
}