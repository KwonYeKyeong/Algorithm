#include <iostream>

using namespace std;

int main()
{
	int n;
	char box;
	int sum = 0;

	cin >> n;
	cin.ignore();

	for (int i = 0; i < n; i++)
	{
		cin.get(box);
		int num = box - '0';
		sum += num;
	}
	cout << sum << endl;
	return 0;
}