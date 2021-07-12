#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
	int answer = 0;
	stack<int> st[31];
	stack<int> basket;

	for (int i = board.size()-1; i>=0; i--) {
		for (int j = 0; j < board.size(); j++) {
			if (board[i][j] == 0) continue;
			st[j].push(board[i][j]);
		}
	}

	for (int m : moves) {
		if (st[m - 1].empty()) continue;

		if (!basket.empty() && st[m - 1].top() == basket.top()) {
			basket.pop();
			answer += 2;
		}
		else
			basket.push(st[m - 1].top());

		st[m - 1].pop();
	}

	return answer;
}