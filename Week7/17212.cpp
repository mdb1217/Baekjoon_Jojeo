#include <iostream>
#include <algorithm>
using namespace std;

int coin[4] = { 7, 5, 2, 1 };
int cnt;

void minCoin(int price) {
	for (int i = 0; i < 4; i++) {
		while (price - coin[i] >= 0) {
			price = price - coin[i];
			cnt++;
		}
	}
}

int main() {
	int price;
	cnt = 0;
	int answer = 100010;

	cin >> price;

	for (int i = 0; i < 4; i++) {
		if (price - coin[i] >= 0) {
			cnt = 1;
			minCoin(price - coin[i]);
			answer = min(answer, cnt);
		}
	}
	if (price == 0)
		answer = 0;
	
	cout << answer << endl;
}