/*
문제 : expression 결과의 최댓값을 구하기
조건 : 연산자 우선순위를 정의할 수 있으나, 2개 이상의 연산자가 동일한 순위를 가지도록 정의할 수 없음.
	   연산 결과가 음수; 결과 = 절댓값
알고리즘 : 구현
*/
#include <string>
#include <vector>
#include <algorithm> // next_permutation()

using namespace std;

long long cal(long long a, long long b, char op) {
	switch (op) {
	case '*':
		a *= b;
		break;
	case '+':
		a += b;
		break;
	case '-':
		a -= b;
		break;
	}

	return a;
}
long long solution(string expression) {
	vector<long long> nums;
	vector<char> opers;
	long long tmp = 0;

	for (char e : expression) {
		if (e == '*' || e == '+' || e == '-') {
			nums.push_back(tmp);
			tmp = 0;
			opers.push_back(e);
		}
		else
			tmp = tmp * 10 + (e - '0');
	}
	nums.push_back(tmp);

	long long answer = 0;
	vector<char> priority = { '*', '+', '-' };
	vector<long long> tmp_nums;
	vector<char> tmp_opers;

	do {
		tmp_nums = nums;
		tmp_opers = opers;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < tmp_opers.size(); j++) {
				if (priority[i] == tmp_opers[j]) {
					tmp_nums[j] = cal(tmp_nums[j], tmp_nums[j + 1], tmp_opers[j]);
					tmp_nums.erase(tmp_nums.begin() + j + 1);
					tmp_opers.erase(tmp_opers.begin() + j);
					j--;
				}
			}
		}

		if (answer < abs(tmp_nums[0]))
			answer = abs(tmp_nums[0]);

	} while (next_permutation(priority.begin(), priority.end()));

	return answer;
}