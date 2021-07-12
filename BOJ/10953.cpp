#include <iostream>
#include <string>

using namespace std;

int main()
{
	int text_case;
	string t1, t2;

	cin >> text_case;

	for (int i = 0; i < text_case; i++)
	{
		getline(cin, t1, ',');
		getline(cin, t2);

		int a = stoi(t1);
		int b = stoi(t2);

		cout << a + b << "\n";
	}
	return 0;
}