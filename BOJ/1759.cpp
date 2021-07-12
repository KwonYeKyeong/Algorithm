#include <iostream>
#include <algorithm>
using namespace std;

const char AEIOU[] = { 'a', 'e', 'i', 'o', 'u' };
int l, c;
char alpha[20];

void secret_key(char* r, int size, int cur, bool aeiou, int cnt) {
	if (size == l && aeiou && cnt>=2) {
		for (int i = 0; i < l; i++)
			cout << r[i];
		cout << '\n';
		return;
	}
	if (cur >= c)
		return;

	for (int i = cur; i < c; i++) {
		bool tmp = false;
		
		r[size] = alpha[i];
		for (int j = 0; j < 5; j++) {
			if (AEIOU[j] == r[size]) {
				tmp = true;
				break;
			}
		}
		if (tmp)
			secret_key(r, size + 1, i + 1, true, cnt);
		else if (aeiou)
			secret_key(r, size + 1, i + 1, true, cnt + 1);
		else secret_key(r, size + 1, i + 1, false, cnt + 1);
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	int size, cnt = 0;
	bool aeiou;

	cin >> l >> c;
	for (int i = 0; i < c; i++) 
		cin >> alpha[i];

	sort(alpha, alpha + c);

	for (int i = 0; i < c - l + 1; i++) {
		char result[20] = {};

		result[0] = alpha[i];
		size = 1;
		aeiou = false;
		for (int j = 0; j < 5; j++) {
			if (AEIOU[j] == result[0]) {
				aeiou = true;
				break;
			}
		}
		if (!aeiou) cnt = 1;
		else cnt = 0;

		secret_key(result, size, i + 1, aeiou, cnt);
	}

	return 0;
}