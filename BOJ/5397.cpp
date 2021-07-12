#include <iostream>
using namespace std;

struct Node {
	char data;
	Node* prev;
	Node* next;
	Node() {
		data = '\0';
		prev = next = NULL;
	}
};

struct List{
	Node* header;
	Node* trailer;
	List() {
		header = new Node();
		trailer = new Node();
		header->next = trailer;
		trailer->prev = header;
	}
};

void printList(List* list) {
	Node* node = list->header;
	while (node = node->next) {
		if (node == list->trailer) break;
		cout << node->data;
	}
}

int main() {
	int test;
	char password;

	cin >> test;

	cin.ignore();

	for (int i = 0; i < test; i++) {
		List myList;
		Node* cur = myList.header;
		while (password = cin.get()) {
			if (password == '\n') break;
			if (password == '<') {
				if (cur != myList.header)
					cur = cur->prev;
			}
			else if (password == '>') {
				if (cur->next != myList.trailer)
					cur = cur->next;
			}
			else if (password == '-') {
				if (cur != myList.header) {
					cur->prev->next = cur->next;
					cur->next->prev = cur->prev;
					cur = cur->prev;
				}
			}
			else {
				Node* tmp = new Node();
				tmp->data = password;
				tmp->prev = cur;
				tmp->next = cur->next;
				cur->next->prev = tmp;
				cur->next = tmp;
				cur = tmp;
			}

		}
		printList(&myList);
		cout << '\n';
	}
	return 0;
}