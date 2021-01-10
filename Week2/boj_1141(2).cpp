#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	int n, cnt = 0;
	string word;
	vector<string> words;

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> word;
		words.push_back(word);
	}

	sort(words.begin(), words.end());

	for (int i = 0; i < n - 1; i++)
		if (words[i] != words[i + 1].substr(0, words[i].size()))
			cnt++;

	cout << cnt + 1 << '\n';

	return 0;
}