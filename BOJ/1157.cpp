#include <iostream>
//#include <cstring>
#include <string>
using namespace std;

int main()
{
	/*
	int alphabet[26] = {};
	char word[1000001] = { '\0' };
	int max_count = 0; // 횟수
	int max_index = 0; // 최댓값이 들어있는 배열의 인덱스값
	int length;

	scanf("%s", word);

	length = strlen(word);

	for (int i = 0; i < length; i++) {
		if (word[i] <= 90 && word[i] >= 65)
			alphabet[int(word[i]) - 65]++;
		else if (word[i] <= 122 && word[i] >= 97)
			alphabet[int(word[i]) - (65 + 32)]++;
	}

	for (int i = 0; i < 26; i++) {
		if (max_count < alphabet[i])
		{
			max_count = alphabet[i];
			max_index = i;
		}
		else if (max_count == alphabet[i])
			max_index = -2; // ? 아스키코드: 63
		}
	cout << char(max_index + 65);
	*/

	int alphabet[26] = { 0 };
	string word;
	int max;
	int max_index;

	getline(cin, word);

	for (int i = 0; i < word.length(); i++)
	{
		if (word.at(i) > 90)
			alphabet[word.at(i) - (32 + 65)]++;
		else
			alphabet[word.at(i) - 65]++;
	}
	max = alphabet[0];
	max_index = 0;
	for (int i = 1; i < 26; i++) {
		if (max < alphabet[i]) {
			max = alphabet[i];
			max_index = i;
		}
		else if (max == alphabet[i])
			max_index = -2;
	}
	cout << char(max_index + 65);
	
	return 0;
}