#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
	int n, m;
	string name;
	vector<string> not_hear, not_seen, not_all;

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		cin >> name;
		not_hear.push_back(name);
	}

	for (int i = 0; i < m; i++) {
		cin >> name;
		not_seen.push_back(name);
	}

	sort(not_hear.begin(), not_hear.end());
	sort(not_seen.begin(), not_seen.end());

	int n_cnt = 0, m_cnt = 0;

	while (n_cnt < n && m_cnt < m) {
		if (not_hear[n_cnt] < not_seen[m_cnt])
			n_cnt++;
		else if (not_hear[n_cnt] > not_seen[m_cnt])
			m_cnt++;
		else {
			not_all.push_back(not_hear[n_cnt]);
			n_cnt++;
			m_cnt++;
		}
	}

	cout << not_all.size() << '\n';

	vector<string>::iterator it;
	for (it = not_all.begin(); it < not_all.end(); it++)
		cout << *it << '\n';

	return 0;
}