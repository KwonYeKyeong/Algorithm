#include <string>
#include <cmath> // pow()
#include <vector>

using namespace std;

int solution(string dartResult) {
	int answer = 0;
	vector<int> nums(4);

	int chance = 0, i = 0;
	int pre_num = nums[chance];
	while (i < dartResult.length()) {
		int num = 0;
		pre_num = nums[chance];
		while (isdigit(dartResult[i]))
			num = 10 * num + (dartResult[i++] - '0');

		if (dartResult[i] == 'D')
			num = pow(num, 2);
		else if (dartResult[i] == 'T')
			num = pow(num, 3);

		if (dartResult[++i] == '*') {
			num *= 2;
			pre_num *= 2;
			i++;
		}
		else if (dartResult[i] == '#') {
			num *= (-1);
			i++;
		}

		nums[++chance] = num;
		nums[chance - 1] = pre_num;
	}

	for (int n : nums) 
		answer += n;
	
	return answer;
}