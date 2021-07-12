#include <iostream>
#include <queue>
using namespace std;

int main() {
/*
	int N;
	queue<int> q;

	cin >> N;

	for (int i = 1; i <= N; i++)
		q.push(i);
	for (int j = 0; j < N - 1; j++) {
		q.pop();

		int temp = q.front();

		q.pop();
		q.push(temp);
	}
	cout << q.front();
*/

	int N;
	queue<int> q;

	cin >> N;

	for (int i = 1; i <= N; i++)
		q.push(i);

	while (q.size() > 1) {
		q.pop();
		int temp = q.front();
		q.pop();
		q.push(temp);
	}

	cout << q.front();

	return 0;
}