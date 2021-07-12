#include <iostream>
using namespace std;

int paper[7], cnt;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	for (int i = 1; i <= 6; i++) 
		cin >> paper[i];
	
	if (paper[6]) {
		cnt += paper[6];
		paper[6] = 0;
	}

	if (paper[5]) {
		cnt += paper[5];
		while (paper[5]--) {
			if (paper[1] < 11) {
				paper[1] = 0;
				break;
			}
			else paper[1] -= 11;
		}
		paper[5] = 0;
	}

	if (paper[4]) {
		cnt += paper[4];
		while (paper[4]--) {
			if (paper[2] < 5) {
				if (paper[1] < ((5 - paper[2]) * 4))
					paper[1] = 0;
				else paper[1] -= ((5 - paper[2]) * 4);
				paper[2] = 0;
			}
			else paper[2] -= 5;
		}
		paper[4] = 0;
	}

	if (paper[3]) {
		cnt += (paper[3] / 4);
		paper[3] %= 4;

		switch (paper[3]) {
		case 0: 
			break;
		case 1:
			if (paper[2] < 5) {
				if (paper[1] < ((5 - paper[2]) * 4 + 7))
					paper[1] = 0;
				else paper[1] -= ((5 - paper[2]) * 4 + 7);
				paper[2] = 0;
			}
			else {
				paper[2] -= 5;
				if (paper[1] < 7)
					paper[1] = 0;
				else paper[1] -= 7;
			}
			cnt++;
			break;
		case 2:
			if (paper[2] < 3) {
				if (paper[1] < ((3 - paper[2]) * 4 + 6))
					paper[1] = 0;
				else paper[1] -= ((3 - paper[2]) * 4 + 6);
				paper[2] = 0;
			}
			else {
				paper[2] -= 3;
				if (paper[1] < 6)
					paper[1] = 0;
				else paper[1] -= 6;
			}
			cnt++;
			break;
		case 3:
			if (paper[2] < 1) {
				if (paper[1] < 9)
					paper[1] = 0;
				else paper[1] -= 9;
			}
			else {
				paper[2] -= 1;
				if (paper[1] < 5)
					paper[1] = 0;
				else paper[1] -= 5;
			}
			cnt++;
		}
		paper[3] = 0;
	}

	if (paper[2]) {
		cnt += (paper[2] / 9);
		paper[2] %= 9;

		if (paper[2]) {
			if (paper[1] < ((9 - paper[2]) * 4))
				paper[1] = 0;
			else paper[1] -= ((9 - paper[2]) * 4);
			paper[2] = 0;
			cnt++;
		}
	}

	if (paper[1]) {
		cnt += (paper[1] / 36);
		paper[1] %= 36;

		if (paper[1]) {
			paper[1] = 0;
			cnt++;
		}
	}

	cout << cnt;

	return 0;
}