#include <iostream>
using namespace std;

int main() {

	int num1; // 입력받을 숫자 
	int num2; // 새로 생성된 숫자
	int a, b; // a: 십의 자리, b: 일의 자리
	int cycle = 0; // 사이클 횟수

	cin >> num1;

	num2 = num1;
	do {
		b = num2 % 10;
		a = (num2 - b) / 10;
		if (num2 < 10)
			num2 = b * 10 + b;
		else
		{
			if (a + b < 10)
				num2 = b * 10 + a + b;
			else
				num2 = b * 10 + (a + b) % 10;
		} 
		cycle++;
	} while (num1 != num2);

	cout << cycle;

	return 0;
}