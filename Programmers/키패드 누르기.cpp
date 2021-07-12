/*
문제 : 전화 키패드를 왼손과 오른손의 엄지손가락만을 이용해서 입력하려고 함.
조건 : 숫자 1, 4, 7 -> 반드시 왼손 엄지손가락, 숫자 3, 6, 9 -> 반드시 오른손 엄지손가락
	   만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지를, 왼손잡이는 왼손 엄지를 사용함.
알고리즘 : 구현
*/
#include <string>
#include <vector>

using namespace std;

struct Hand {
	int x, y;
	Hand(int xx, int yy) {
		x = xx;
		y = yy;
	}
	void setPos(int xx, int yy) {
		x = xx;
		y = yy;
	}
};

int _abs(int i) {
	if (i < 0)
		return (-1)*i;
	return i;
}
string solution(vector<int> numbers, string hand) {
	string answer = "";
	Hand L(3, 0); Hand R(3, 2);
	int left_right = 0; // 0 : left, 1 : right
	int def; // default value of 'left_right'
	int disL, disR;

	if (hand == "left")
		def = 0;
	else def = 1;

	for (int n : numbers) {
		switch (n) {
		case 1:
			left_right = 0;
			L.setPos(0, 0);
			break;
		case 2: // (0, 1)
			disL = L.x + _abs(L.y - 1);
			disR = R.x + _abs(R.y - 1);
			if (disL == disR) {
				left_right = def;
				if (def == 0)
					L.setPos(0, 1);
				else R.setPos(0, 1);
			}
			else if (disL < disR) {
				left_right = 0;
				L.setPos(0, 1);
			}
			else {
				left_right = 1;
				R.setPos(0, 1);
			}
			break;
		case 3:
			left_right = 1;
			R.setPos(0, 2);
			break;
		case 4:
			left_right = 0;
			L.setPos(1, 0);
			break;
		case 5: // (1, 1)
			disL = _abs(L.x - 1) + _abs(L.y - 1);
			disR = _abs(R.x - 1) + _abs(R.y - 1);
			if (disL == disR) {
				left_right = def;
				if (def == 0)
					L.setPos(1, 1);
				else R.setPos(1, 1);
			}
			else if (disL < disR) {
				left_right = 0;
				L.setPos(1, 1);
			}
			else {
				left_right = 1;
				R.setPos(1, 1);
			}
			break;
		case 6:
			left_right = 1;
			R.setPos(1, 2);
			break;
		case 7:
			left_right = 0;
			L.setPos(2, 0);
			break;
		case 8: // (2, 1)
			disL = _abs(L.x - 2) + _abs(L.y - 1);
			disR = _abs(R.x - 2) + _abs(R.y - 1);
			if (disL == disR) {
				left_right = def;
				if (def == 0)
					L.setPos(2, 1);
				else R.setPos(2, 1);
			}
			else if (disL < disR) {
				left_right = 0;
				L.setPos(2, 1);
			}
			else {
				left_right = 1;
				R.setPos(2, 1);
			}
			break;
		case 9:
			left_right = 1;
			R.setPos(2, 2);
			break;
		case 0: // (3, 1)
			disL = _abs(L.x - 3) + _abs(L.y - 1);
			disR = _abs(R.x - 3) + _abs(R.y - 1);
			if (disL == disR) {
				left_right = def;
				if (def == 0)
					L.setPos(3, 1);
				else R.setPos(3, 1);
			}
			else if (disL < disR) {
				left_right = 0;
				L.setPos(3, 1);
			}
			else {
				left_right = 1;
				R.setPos(3, 1);
			}
		}

		if (left_right)
			answer += 'R';
		else answer += 'L';
	}

	return answer;
}