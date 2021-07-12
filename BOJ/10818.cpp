#include <iostream>
using namespace std;

int main()
{
	int num;
	int box[100];

	cin >> num;

	for (int i = 0; i < num; i++)
		cin >> box[i];

	int min = box[0];
	int max = box[0];

	for (int j = 1; j < num; j++)
	{
		if (min > box[j])
			min = box[j];
		if (max < box[j])
			max = box[j];
	}

	cout << min << ' ' << max << "\n";
	return 0;
}