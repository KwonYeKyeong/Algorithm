#include <iostream>
#include <string>
#include <vector>
using namespace std;

vector<int> vec(26);

int main() {
	string s;
	
	cin >> s;

	for (int i = 0; i < s.length(); i++) 
		vec[s[i] - 'a']++;
	
	for (auto a : vec) cout << a << ' ';

	return 0;
}