#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(string a, string b) {
	return a.size() < b.size();
}

int main()
{
	int n, remove_cnt = 0;
	string word;
	vector<string> words;

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> word;
		words.push_back(word);
	}

	sort(words.begin(), words.end(), compare);

	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			if (words[i] == words[j].substr(0, words[i].size())) {
				remove_cnt++;
				break;
			}
		}
	}

	cout << n - remove_cnt << '\n';

	return 0;
}