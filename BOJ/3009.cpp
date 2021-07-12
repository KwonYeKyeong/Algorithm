#include <iostream>
using namespace std;

struct Point {
	int x, y;
	void setPos(int xx, int yy) {
		x = xx;
		y = yy;
	}
	void print() {
		cout << x << ' ' << y;
	}
};

int main() {
	int a, b, len1, len2, len3;
	Point p1, p2, p3, p4;

	for (int i = 0; i < 3; i++) {
		cin >> a >> b;
		switch (i) {
		case 0:
			p1.setPos(a, b);
			break;
		case 1:
			p2.setPos(a, b);
			break;
		case 2:
			p3.setPos(a, b);
		}
	}

	if (p1.x == p2.x) 
		p4.x = p3.x;
	else if (p1.x == p3.x)
		p4.x = p2.x;
	else p4.x = p1.x;

	if (p1.y == p2.y)
		p4.y = p3.y;
	else if (p1.y == p3.y)
		p4.y = p2.y;
	else p4.y = p1.y;

	p4.print();

	return 0;
}