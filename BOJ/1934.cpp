#include <iostream>
using namespace std;

int gcd(int, int);
int lcm(int, int);

int main()
{
	int text_case;
	cin >> text_case;

	int a, b;
	for (int i = 0; i < text_case; i++)
	{
		cin >> a >> b;
		cout << lcm(a, b) << endl;
	}
	return 0;
}
int gcd(int a, int b)
{
	if (a < b)
	{
		if (b % a == 0)
			return a;
		else
			return gcd(a, b%a);
	}
	else
	{
		if (a % b == 0)
			return b;
		else
			return gcd(b, a % b);
	}
}
int lcm(int a, int b)
{
	return a * b / gcd(a, b);
}