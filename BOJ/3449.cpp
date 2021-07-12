#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
	int t, hamming_distance;
	string k1, k2;
	cin >> t;
	while (t--) {
		vector<char> v1;
		vector<char> v2;
		hamming_distance = 0;

		cin >> k1 >> k2;
		for (int i = 0; i < k1.length(); i++) {
			v1.push_back(k1[i]);
			v2.push_back(k2[i]);
		}

		for (int i = 0; i < v1.size(); i++) 
			if (v1[i] != v2[i]) hamming_distance++;
		
		cout << "Hamming distance is " << hamming_distance << ".\n";
	}
	return 0;
}