#include <iostream>
using namespace std;

int main()
{
	int jack, mary; // 월, 일

	cin >> jack >> mary;

	int month[12] = { 31,28,31,30,31,30,31,31,30,31,30,31 };
	int day = 0;

	for (int i = 1; i < jack; i++)
		day += month[i-1];
	day += mary;

	int week = day % 7;
	switch (week)
	{
	case 0:
		cout << "SUN\n";
		break;
	case 1:
		cout << "MON\n";
		break;
	case 2:
		cout << "TUE\n";
		break;
	case 3:
		cout << "WED\n";
		break;
	case 4:
		cout << "THU\n";
		break;
	case 5:
		cout << "FRI\n";
		break;
	case 6:
		cout << "SAT\n";
		break;
	default:
		break;
	}

	return 0;
}