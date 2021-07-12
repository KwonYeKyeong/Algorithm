#include <iostream>
using namespace std;

#define SIZE = 500000;

template <typename T>
class CircularQueue {
public:
	int f, r, queueSize;
	T arr[SIZE];

	CircularQueue() {
		f = r = queueSize = 0;
	}
	void enqueue(T X) {
		if (queueSize == SIZE) return;
		arr[r++] = X;
		r %= SIZE;
		queueSize++;
	}
	void dequeue() {
		// if (empty()) return;
		f++;
		f %= SIZE;
		queueSize--;
	}
	bool empty() {
		return (f == r);
	}
	int size() {
		return queueSize;
	}
	T front() {
		if (empty()) return -1;
		return arr[f];
	}
};

int main() {
	int N, k;
	CircularQueue<int> q;
	cin >> N;

	for (int i = 1; i <= N; i++)
		q.enqueue(i);

	while (q.size() > 1) {
		q.dequeue();
		k = q.front();
		q.dequeue();
		q.enqueue(k);
	}

	cout << q.front();

	return 0;
}


/*
struct Node {
	int data;
	Node* next;
	Node() {
		data = 0;
		next = NULL;
	}
};

struct Queue {
	Node* head;
	Node* tail;
	Queue() {
		head = NULL;
		tail = NULL;
	}
	void push(int X) {
		Node* node = new Node();
		node->data = X;
		if (head == NULL)
			head = node;
		else tail->next = node;
		tail = node;
	}
	void pop() {
		Node* temp = head;
		head = head->next;
		delete temp;
	}
	int size() {
		if (head == NULL) return 0;
		else {
			int cnt = 1;
			Node* cur = head;
			while (cur != tail) {
				cur = cur->next;
				cnt++;
			}
			return cnt;
		}
	}
	int front() {
		return head->data;
	}
};

int main() {
	int N, k;
	Queue q;
	cin >> N;

	for (int i = 1; i <= N; i++)
		q.push(i);

	while (q.size() > 1) {
		q.pop();
		k = q.front();
		q.pop();
		q.push(k);
	}

	cout << q.front();

	return 0;
}
*/