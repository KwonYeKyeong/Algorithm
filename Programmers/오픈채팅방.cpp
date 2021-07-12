#include <string>
#include <vector>
#include <map>

using namespace std;

const string message[2] = { "님이 들어왔습니다.", "님이 나갔습니다." };

vector<string> solution(vector<string> record) {
	vector<string> answer;
	map<string, string> m;
	size_t pos;
	string uid, nickname;

	for (string r : record) {
		if (r[0] == 'E') {
			r = r.substr(6); // Enter 제거

			pos = r.find(' ');
			uid = r.substr(0, pos);
			nickname = r.substr(pos + 1);
			m[uid] = nickname;
		}
		else if (r[0] == 'C') {
			r = r.substr(7); // Change 제거

			pos = r.find(' ');
			uid = r.substr(0, pos);
			nickname = r.substr(pos + 1);
			m[uid] = nickname;
		}
	}

	for (string r : record) {
		string tmp;
		if (r[0] == 'E') {
			r = r.substr(6);

			pos = r.find(' ');
			uid = r.substr(0, pos);

			tmp = m[uid] + message[0];
			answer.push_back(tmp);
		}
		else if (r[0] == 'L') {
			r = r.substr(6); // Leave 제거

			pos = r.find(' ');
			uid = r.substr(0, pos);

			tmp = m[uid] + message[1];
			answer.push_back(tmp);
		}
	}

	return answer;
}