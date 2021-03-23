//Silver 3 <������ ������ �ʾ�!> - ���� -
#include <iostream>
#include <stack>
using namespace std;

int main() {
	int n;
	stack <pair<int, int> > hw;
	bool isTrue;
	int score;
	int time;
	int scoreSum = 0;

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> isTrue;
		if (isTrue) {
			cin >> score >> time;
			if (time == 1) {
				scoreSum += score;
			}
			else {
				hw.push({ score, time - 1 });
			}
		}
		else {
			if (!hw.empty()) { //����!
				score = hw.top().first;
				time = hw.top().second - 1;
				hw.pop();
				if (time > 0) {
					hw.push({ score, time });
				}
				else {
					scoreSum += score;
				}
			}
		}
	}

	cout << scoreSum << endl;
}