#include <string>
#include <vector>

using namespace std;

string step_one(string id) {
	for (int i = 0; i < id.length(); i++) {
		if (id[i] >= 'A' && id[i] <= 'Z')
			id[i] = char(id[i] - 'A' + 'a');
	}
	return id;
}
string step_two(string id) {
	string tmp_id = "";
	for (int i = 0; i < id.length(); i++) {
		if (id[i] >= 'a' && id[i] <= 'z') tmp_id += id[i];
		if (isdigit(id[i])) tmp_id += id[i];
		if (id[i] == '-' || id[i] == '_' || id[i] == '.') tmp_id += id[i];
	}
	return tmp_id;
}
string step_three(string id) {
	string tmp_id = "";
	tmp_id += id[0];
	for (int i = 1; i < id.length(); i++) {
		if (id[i] == '.' && id[i - 1] == '.') continue;
		tmp_id += id[i];
	}
	return tmp_id;
}
string step_four(string id) {
	if (id.length() > 0 && id[0] == '.')
		id = id.substr(1, id.length() - 1);
	if (id.length() > 0 && id[id.length() - 1] == '.')
		id = id.substr(0, id.length() - 1);
	return id;
}
string step_five(string id) {
	if (id == "")
		id += 'a';
	return id;
}
string step_six(string id) {
	if (id.length() > 15) {
		id = id.substr(0, 15);
		if (id[14] == '.')
			id = id.substr(0, 14);
	}
	return id;
}
string step_seven(string id) {
	while (id.length() <= 2) 
		id += id[id.length() - 1];
	return id;
}
string solution(string new_id) {
	string answer = "";

	answer = step_one(new_id);
	answer = step_two(answer);
	answer = step_three(answer);
	answer = step_four(answer);
	answer = step_five(answer);
	answer = step_six(answer);
	answer = step_seven(answer);

	return answer;
}