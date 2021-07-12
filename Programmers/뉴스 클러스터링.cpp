#include <string>
#include <vector>
#include <algorithm> // transform, find

using namespace std;

int solution(string str1, string str2) {
	int answer = 0;
	int max, min = 0;
	vector<string> s1, s2;

	transform(str1.begin(), str1.end(), str1.begin(), ::toupper);
	transform(str2.begin(), str2.end(), str2.begin(), ::toupper);

	for (int i = 0; i < str1.length() - 1; i++) {
		string str = str1.substr(i, 2);
		if (str[0] >= 'A' && str[0] <= 'Z' && str[1] >= 'A' && str[1] <= 'Z')
			s1.push_back(str);
	}
	for (int i = 0; i < str2.length() - 1; i++) {
		string str = str2.substr(i, 2);
		if (str[0] >= 'A' && str[0] <= 'Z' && str[1] >= 'A' && str[1] <= 'Z')
			s2.push_back(str);
	}

	if (s1.empty() && s2.empty())
		answer = 65536;
	else {
		max = s1.size() + s2.size();

		for (string s : s1) {
			auto itr = find(s2.begin(), s2.end(), s);
			if (itr != s2.end()) {
				min++;
				s2.erase(itr);
			}
		}

		max -= min;

		double tmp = double(min) / double(max);
		answer = tmp * 65536;
	}

	return answer;
}