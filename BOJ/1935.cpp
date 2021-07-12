#include <iostream>
#include <iomanip>
#include <stack>
using namespace std;

int main() {
	int N; // 피연산자의 개수
	char s[101];
	double n[26];
	stack<double> st; 

	cin >> N;
	cin.ignore();
	cin.getline(s, 100);

	for (int j = 0; j < N; j++)
		cin >> n[j];

	for (int i = 0; s[i] != NULL; i++) {
		if (double(s[i]) >= 65 && double(s[i]) <= 90) 
			st.push(n[int(s[i])-65]);
		else {
			double p = st.top();
			st.pop();
			double q = st.top();
			st.pop();
			if (s[i] == '+')
				st.push(q + p);
			else if (s[i] == '-')
				st.push(q - p);
			else if (s[i] == '*')
				st.push(q * p);
			else if (s[i] == '/')
				st.push(q / p);
		}
	}

	cout << fixed;
	cout.precision(2);
	cout << st.top();
	
	return 0;
}