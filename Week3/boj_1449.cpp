#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	int n, l, value, cnt = 0;
	vector<int> pos;

	cin >> n >> l;

	for (int i = 0; i < n; i++) {
		cin >> value;
		pos.push_back(value);
	}

	sort(pos.begin(), pos.end());
	pos.push_back(2000);

	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n + 1; j++) {
			if (pos[j] - pos[i] + 1 > l) {
				cnt++;
				i = j - 1;
				break;
			}
		}
	}

	cout << cnt << '\n';

	return 0;
}