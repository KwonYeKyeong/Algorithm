#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

template <typename T>
class stack {
public:
	T arr[101];
	int t = -1;

	void push(T X) {
		t++;
		arr[t] = X;
	}
	T pop() {
		T c;
		if (t != -1) {
			c = arr[t];
			t--;
		}
		return c;
	}
	T top() {
		T c;
		if (t != -1) c = arr[t];
		return c;
	}
	bool empty() {
		if (t == -1) return true;
		return false;
	}
};

int main() {
	int N;
	string s;
	double num[26];
	stack<double> st;

	cin >> N >> s;

	for (int i = 0; i < N; i++)
		cin >> num[i];

	int k = 0;
	for (int j = 0; j < s.length(); j++) {
		if (s[j] == '*' || s[j] == '/'
			|| s[j] == '+' || s[j] == '-') {
			double a = st.pop();
			double b = st.pop();
			switch (s[j]) {
			case '+': 
				st.push(b + a);
				break;
			case '-':
				st.push(b - a);
				break;
			case '*':
				st.push(b * a);
				break;
			case '/':
				st.push(b / a);
				break;
			}
		}
		else st.push(num[int(s[j])-65]);
	}

	cout << fixed;
	cout.precision(2);
	cout << st.top();

	return 0;
}