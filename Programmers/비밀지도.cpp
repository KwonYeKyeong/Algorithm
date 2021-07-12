#include <string>
#include <vector>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
	vector<string> answer;

	for (int i = 0; i < n; i++) {
		string s = "";
		int c, c1, c2;
		for (int j = 0; j < n; j++) {
			c1 = (arr1[i] % 2 ? 1 : 0);
			arr1[i] /= 2;
			c2 = (arr2[i] % 2 ? 1 : 0);
			arr2[i] /= 2;

			c = c1 | c2;
			s = (c == 1 ? '#' : ' ') + s;
		}
		answer.push_back(s);
	}

	return answer;
}

int main() {
	int n = 5;
	vector<int> arr1 = { 9, 20, 28, 18, 11 };
	vector<int> arr2 = { 30, 1, 21, 17, 28 };

	solution(n, arr1, arr2);
}