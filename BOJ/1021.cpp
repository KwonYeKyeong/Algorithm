#include <iostream>
#include <queue>
using namespace std;

#define MAX 100

struct circularQueue {
	int front = 0;
	int rear = 0;
	int arr[MAX];

	void enQueue(int n) {
		rear = (rear + 1) % MAX;
		arr[rear] = n;
	}

	void deQueue() {
		front = (front + 1) % MAX;
	}

	bool empty() {
		if (front == rear)
			return true;
		return false;
	}
};

int main() {
	int N, M; // 큐의 크기, 뽑아내려고 하는 수의 개수
	int count = 0; // 2, 3번 연산의 최솟값
	int arr[MAX];
	circularQueue q;

	cin >> N >> M;

	for (int i = 1; i <= N; i++)
		q.enQueue(i);

	for (int j = 1; j <= M; j++)
		cin >> arr[j];

	for (int k = 0; k < M; k++) {
		while (1) {
			if (q.front == arr[k + 1]) {
				q.deQueue();
				break;
			}
			// 2번 연산; front와 더 가까울 경우
			// 3번 연산; rear와 더 가까울 경우

		}
	}

	return 0;
}