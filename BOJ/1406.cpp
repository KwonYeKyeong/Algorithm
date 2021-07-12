#include <iostream>
using namespace std;
/*
struct Node {
	char data;
	Node* prev;
	Node* next;
	Node() {
		data = '\0';
		prev = next = NULL;
	}
};

struct List {
	Node* header;
	Node* trailer;
	List() {
		header = new Node();
		trailer = new Node();
		header->next = trailer;
		trailer->prev = header;
	}
};

void addNode(List* list, char a) {
	Node* node = new Node();
	node->data = a;
	if (list->header->next == list->trailer) {
		list->header->next = node;
		node->prev = list->header;
		node->next = list->trailer;
		list->trailer->prev = node;
	}
	else {
		node->next = list->trailer;
		node->prev = list->trailer->prev;
		node->prev->next = node;
		list->trailer->prev = node;
	}
}

void printList(List* list) {
	Node* tmp = list->header;
	while (tmp = tmp->next) {
		if (tmp == list->trailer) break;
		cout << tmp->data;
	}
}

int main(){
	char input, c; // 초기에 편집기에 입력되어 있는 문자열, 명령어
	List myList;
	int n; // 명령어 개수

	while (input = cin.get()) {
		if (input == '\n') break;
		addNode(&myList, input);
	}

	Node* cur = myList.trailer;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> c;
		if (c == 'L') {
			if (cur->prev != myList.header)
				cur = cur->prev;
		}
		else if (c == 'D') {
			if (cur != myList.trailer)
				cur = cur->next;
		}
		else if (c == 'B') {
			if (cur->prev != myList.header) {
				cur->prev = cur->prev->prev;
				cur->prev->next = cur;
			}
		}
		else if (c == 'P') {
			char plus;
			cin >> plus;
			Node* temp = new Node();
			temp->data = plus;
			temp->prev = cur->prev;
			temp->next = cur;
			cur->prev = temp;
			temp->prev->next = temp;
		}
	}

	printList(&myList);

	return 0;
}
*/

template <typename T>
class stack {
public:
	char arr[100001];
	int t = -1;

	void push(char X) {
		t++;
		arr[t] = X;
	}
	char pop() {
		char c;
		if (t != -1) { 
			c = arr[t];
			t--;
		}
		return c;
	}
	bool empty() {
		if (t == -1) return true;
		return false;
	}
};

int main() {
	stack<char> s;
	stack<char> _s;
	char c, k;
	int N;

	while (cin.get(c)){
		if (c == '\n') break;
		s.push(c);
	}
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> k;
		if (k == 'L') {
			if (!s.empty()) {
				char b = s.pop();
				_s.push(b);
			}
		}
		else if (k == 'D') { 
			if (!_s.empty()) { 
				char b = _s.pop();
				s.push(b);
			}
		}
		else if (k == 'B') {
			if(!s.empty()) s.pop();
		}
		else if (k == 'P') {
			char input;
			cin >> input;
			s.push(input);
		}
	}
	while (!s.empty()) {
		char b = s.pop();
		_s.push(b);
	}
	while (!_s.empty()) cout << _s.pop();

	return 0;
}