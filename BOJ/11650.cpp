#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Point {
	int x, y;
	Point(int xx, int yy) {
		x = xx;
		y = yy;
	}
};

bool compare(Point a, Point b) {
	if (a.x == b.x) return a.y < b.y;
	return a.x < b.x;
}

int main() {
	int n, a, b;
	vector<Point> vec;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		Point p(a, b);
		vec.push_back(p);
	}

	sort(vec.begin(), vec.end(), compare);

	for (Point v : vec) 
		cout << v.x << ' ' << v.y << '\n';
	
	return 0;
}