//Silver 3 <repairman> - greedy algorithm -
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int leak_cnt, tape_length, tmp;
	int tape_cnt = 0, tape_left;
	bool last_leak = 0;
	vector <int> leak;
	
	cin >> leak_cnt >> tape_length;

	for (int i = 0; i < leak_cnt; i++) {
		cin >> tmp;
		leak.push_back(tmp);
	}
	
	sort(leak.begin(), leak.end());

	for (int idx = 1; idx < leak_cnt; idx++) {
		tape_cnt++;
		tape_left = idx - 1;
		while (leak[tape_left] - 0.5 + tape_length >= leak[idx] + 0.5) { //���� ������ ���ƾ� �� ������ ���� ���� ������ �������� ������ ������ �۰ų� ������(���ԵǸ�)
			if (idx == leak_cnt - 1) {
				last_leak = 1;
				break;
			}
			idx++;
		}
	}

	if (!last_leak)
		tape_cnt++;

	cout << tape_cnt << endl;
}