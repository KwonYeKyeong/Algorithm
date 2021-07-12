#include <iostream>
using namespace std;

// ¿¡·¯³²..¤Ð¤Ì

class Node {
public:
	int data;
	Node* next;

	Node(int X) {
		data = X;
		next = NULL;
	}
};
class Queue {
public:
	Node* head;
	Node* tail;

	Queue() {
		head = tail = NULL;
	}
	void enqueue(int X) {
		Node* node = new Node(X);
		if (head == NULL) { 
			head = node;
			tail = node;
		}
		else {
			tail->next = node;
			tail = node;
			tail->next = head;
		}
	}
	void dequeue() {
		Node* temp = head;
		tail->next = head->next;
		head = head->next;
		delete temp;
	}
	int front() {
		return head->data;
	}
	bool empty() {
		return (head == NULL);
	}
};

int main() {
	int N, K;
	int arr[100000];
	Queue q;
	cin >> N >> K;

	for (int i = 1; i <= N; i++) q.enqueue(i);
	for (int s = 0; s < N - 1; s++) {
		for (int j = 1; j < K; j++) {
			q.enqueue(q.front());
			q.dequeue();
		}
		arr[s] = q.front();
		q.dequeue();
	}

	cout << '<';
	for (int i = 0; i < N - 1; i++) 
		cout << arr[i] << ", ";
	cout << q.front() << '>';

	return 0;
}