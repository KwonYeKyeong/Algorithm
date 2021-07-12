#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
	stack<int> st;
	string s;
	bool bracket = false; // true : 올바른 괄호열 <-> false
	int tmp, sum = 0;

	cin >> s;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] != '(' && s[i] != ')' && s[i] != '[' &&s[i] != ']') {
			bracket = false;
			break;
		}

		// ( : -2, [ : -3
		if (s[i] == '(')
			st.push(-2);
		else if (s[i] == '[')
			st.push(-3);
		else if (!st.empty()) {
			if (s[i] == ')') {
				if (st.top() == -2) {
					st.pop();
					st.push(2);
				}
				else if (st.top() == -3) {
					bracket = false;
					break;
				}
				else {
					tmp = 0;
					while (!st.empty() && st.top() != -2 && st.top() != -3) {
						tmp += st.top();
						st.pop();
					}
					if (st.empty() || st.top() == -3) {
						bracket = false;
						break;
					}
					else if (st.top() == -2) {
						st.pop();
						st.push(2 * tmp);
					}
				}
			}
			else if (s[i] == ']') {
				if (st.top() == -3) {
					st.pop();
					st.push(3);
				}
				else if (st.top() == -2) {
					bracket = false;
					break;
				}
				else {
					tmp = 0;
					while (!st.empty() && st.top() != -2 && st.top() != -3) {
						tmp += st.top();
						st.pop();
					}
					if (st.empty() || st.top() == -2) {
						bracket = false;
						break;
					}
					else if (st.top() == -3) {
						st.pop();
						st.push(3 * tmp);
					}
				}
			}
		}
	}

	while (!st.empty()) {
		if (st.top() == -2 || st.top() == -3) {
			bracket = false;
			break;
		}
		sum += st.top();
		st.pop();
		bracket = true;
	}

	if (!bracket) sum = 0;
	cout << sum;
	return 0;
}
/*
#include <iostream>
#include <stack>
#include <string>
using namespace std;

string input;
stack<char> s;

int main(void) {

	ios_base::sync_with_stdio(0);
	cin.tie(0); //cin 실행속도 향상

	cin >> input;

	int result = 0;
	int temp = 1;
	bool impossible = false;

	for (int i = 0; i < input.size(); i++) {
		if (input[i] == '(') {
			temp *= 2;
			s.push('(');
		}
		else if (input[i] == '[') {
			temp *= 3;
			s.push('[');
		}
		//불가능한 경우
		else if (input[i] == ')' && (s.empty() || s.top() != '(')) {
			impossible = true;
			break;
		}
		else if (input[i] == ']' && (s.empty() || s.top() != '[')) {
			impossible = true;
			break;
		}
		else if (input[i] == ')') {
			if (input[i - 1] == '(')
				result += temp;
			s.pop();
			temp /= 2;
		}
		else if (input[i] == ']') {
			if (input[i - 1] == '[')
				result += temp;
			s.pop();
			temp /= 3;
		}
	}

	if (impossible || !s.empty())
		cout << 0 << "\n";
	else
		cout << result << "\n";

	return 0;

}
*/