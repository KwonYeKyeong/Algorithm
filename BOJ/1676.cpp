#include <iostream>
using namespace std;

int main()
{
	/* 방법1)

	int n;
	int result = 1; // 팩토리얼 값
	int count = 0; // 0의 개수

	cin >> n;

	for (int i = 2; i <= n; i++)
	result *= i;

	while (result % 10 == 0)
	{
	count++;
	result /= 10;
	}

	cout << count;*/

	// 방법 2)
	int n;
	int count = 0; // 0의 개수
	cin >> n;

	for (int i = 5; i <= n; i += 5)
	{
		int copy = i;
		while (copy % 5 == 0)
		{
			count++;
			copy /= 5;
		}
	}

	cout << count;
	return 0;
}