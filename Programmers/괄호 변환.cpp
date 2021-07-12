#include <string>
#include <vector>
#include <stack>

using namespace std;

bool isCorrectString(string p) { // '올바른 괄호 문자열'인지 확인하는 함수
	stack<char> st;

	for (int i = 0; i< p.length(); i++) {
		if (p[i] == '(')
			st.push('(');
		else {
			if (st.empty()) return false;
			else st.pop();
		}
	}

	if (st.empty()) return true;
	return false;
}
int U_V(string p) {
	int cnt1 = 0, cnt2 = 0; // cnt1 : '('의 개수, cnt2 : ')'의 개수
	int idx = 0; // u와 v를 나누는 인덱스 번호
	for (int i = 0; i < p.length(); i++) {
		if (p[i] == '(') cnt1++;
		else if (p[i] == ')') cnt2++;

		if (cnt1 == cnt2) {
			idx = i;
			break;
		}
	}
	return idx;
}
string reverseString(string p) { // 문자열의 괄호 방향을 뒤집는 함수
	string ret = "";
	for (int i = 0; i < p.length(); i++) {
		if (p[i] == '(')
			ret += ')';
		else ret += '(';
	}
	return ret;
}
string recursion(string w) { // '균형잡힌 괄호 문자열' -> '올바른 괄호 문자열' 재귀 함수
	string ret = "";

	if (w == "" || isCorrectString(w)) ret = w;
	else {
		string u, v;
		int idx = U_V(w);
		u = w.substr(0, idx + 1);
 		v = w.substr(idx + 1, w.length() - idx - 1);
		if (isCorrectString(u))
			ret = u + recursion(v);
		else ret = '(' + recursion(v) + ')' + reverseString(u.substr(1, u.length() - 2));
	}

	return ret;
}
string solution(string p) {
	string answer = "";

	answer = recursion(p);

	return answer;
}