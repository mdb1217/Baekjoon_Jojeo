//Silver 3 <치킨치킨치킨> - 브루트포스 -
#include <iostream>
#include <algorithm>
using namespace std;

int people, chicken;
int grade[30][30];
int comb[30] = { 0 };
int answer = -1;

void selectChicken(int k, int start) {
	if (k == 3) {
		int sum = 0;
		int highest;
		for (int i = 0; i < people; i++) {
			highest = -1;
			for (int j = 0; j < 3; j++) {
				highest = max(highest, grade[i][comb[j]]);
			}
			sum += highest;
		}
		answer = max(answer, sum);
	}
	else {
		for (int i = start; i < chicken; i++) {
			comb[k] = i;
			selectChicken(k + 1, i + 1);
		}
	}
}

int main() {
	cin >> people >> chicken;

	for (int i = 0; i < people; i++) {
		for (int j = 0; j < chicken; j++) {
			cin >> grade[i][j];
		}
	}

	selectChicken(0, 0);

	cout << answer << endl;
}