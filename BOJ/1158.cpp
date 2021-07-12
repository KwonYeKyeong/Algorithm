#include <iostream>
#include <vector>
using namespace std;

/*
struct Node {
	Node* next;
	int data;
	Node() {
		next = NULL;
		data = 0;
	}
};

struct List {
	Node* head;
	List() {
		head = NULL;
	}
};

void addNode(List* list, int n) { // 마지막 노드에 새 노드 추가하는 방식
	Node* new_node = new Node();
	new_node->data = n;
	if (list->head == NULL)
		list->head = new_node;
	else {
		Node* temp = list->head;
		while (temp->next != NULL)
			temp = temp->next;
		temp->next = new_node;
	}
}

int removeNode(List* list) { // 헤드의 다음 노드(target) 지우는 방식
	Node* temp = list->head->next;
	int value = temp->data;

	list->head->next = list->head->next->next;

	delete temp;

	return value;
}

int main() {
	List myList;
	vector<int> result;
	int N, K;
	cin >> N >> K;

	for (int i = 1; i <= N; i++) 
		addNode(&myList, i);
	
	// 마지막 노드와 첫번째 노드 잇기
	Node* temp = myList.head;
	while (temp->next != NULL)
		temp= temp->next;
	temp->next = myList.head;

	// 순열 저장하기
	while (result.size() != N) {
		if (K == 1) { // K가 1일 때
			Node* tmp_node = myList.head;
			result.push_back(tmp_node->data);
			myList.head = myList.head->next;
			delete tmp_node;
		}
		else { // K가 1이 아닐 때
			for (int j = 1; j < K - 1; j++)
				myList.head = myList.head->next;
			result.push_back(removeNode(&myList));
			myList.head = myList.head->next;
		}
	}

	// 출력
	cout << "<";
	for (int m = 0; m < N; m++) {
		if (m == N - 1)
			cout << result[m] << ">";
		else cout << result[m] << ", ";
	}
	return 0;
}
*/

/*
struct Node {
	int elem;
	Node* next;
	Node() {
		elem = 0;
		next = NULL;
	}
};

struct List {
	Node* head;
	List() {
		head = NULL;
	}
};

void addNode(List* list, int n) {
	Node* node = new Node();
	node->elem = n;
	if (list->head == NULL) {
		list->head = node;
	}
	else {
		Node* temp = list->head;
		while (temp->next != NULL) 
			temp = temp->next;
		temp->next = node;
	}
}

int removeNode(List* list) { // 헤드의 다음 노드를 삭제
	if (list->head == NULL) return -1;
	else {
		Node* temp = list->head->next;
		int ret = list->head->next->elem; // 반환할 elem 값
		list->head->next = list->head->next->next;
		delete temp;
		return ret;
	}
}

int main() {
	int N, K;
	List myList;
	vector<int> vec;

	cin >> N >> K;
	
	for (int i = 1; i <= N; i++)
		addNode(&myList, i);

	Node* temp = myList.head;
	while (temp->next != NULL)
		temp = temp->next;
	temp->next = myList.head;

	if (N == 1) {
		cout << "<1>";
		return 0;
	}
	else {
		if (K == 1) {
			for (int j = 1; j <= N; j++)
				vec.push_back(j);
		}
		else {
			while (vec.size() < N) {
				if (vec.size() == 0) {
					for (int j = 0; j < K - 2; j++)
						myList.head = myList.head->next;
				}
				else {
					for (int j = 0; j < K - 1; j++)
						myList.head = myList.head->next;
				}
				vec.push_back(removeNode(&myList));
			}
		}

		// 출력
		cout << '<';
		for (int k = 0; k < N; k++) {
			if (k != N - 1) cout << vec[k] << ", ";
			else cout << vec[k] << '>';
		}
		return 0;
	}
}
*/

class Node {
public:
	int data;
	Node* next;
	Node() {
		data = 0;
		next = NULL;
	}
	Node(int a) {
		data = a;
		next = NULL;
	}
};

class List {
public:
	Node* head;
	Node* tail;
	List() {
		head = NULL;
		tail = NULL;
	}

	void addNode(int a) {
		Node* node = new Node(a);
		if (head == NULL) 
			head = node;		
		else 
			tail->next = node;
		tail = node;
	}
};

List myList;
vector<int> vec;

int main() {
	int N, K;
	cin >> N >> K;

	if (K != 1) {
	for (int i = 1; i <= N; i++) 
		myList.addNode(i);
	
	myList.tail->next = myList.head;

	
		Node* cur = myList.head;
		for (int j = 0; j < K - 2; j++)
			cur = cur->next;
		vec.push_back(cur->next->data);
		cur->next = cur->next->next;

		while (vec.size() < N) {
			for (int m = 0; m < K - 1; m++)
				cur = cur->next;
			vec.push_back(cur->next->data);
			cur->next = cur->next->next;
		}
	}
	else {
		for (int i = 1; i <= N; i++)
			vec.push_back(i);
	}

	cout << '<';
	for (auto n : vec) {
		if(n!=vec[vec.size()-1])
			cout << n << ", ";
		else cout << n << '>';
	}
	
	return 0;
}