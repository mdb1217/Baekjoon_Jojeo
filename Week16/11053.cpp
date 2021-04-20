//Silver 2 <가장 긴 증가하는 부분 수열> - DP -
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int n, tmp = 1;
	int num[1001] = {0};
	int longest_len[1001] = { 0 };
	int ans = 1;

	cin >> n;

	cin >> num[0];
	longest_len[0] = 1;

	for (int i = 1; i < n; i++) {
		cin >> num[i];
		for (int j = i - 1; j >= 0; j--) {
			if (num[j] < num[i]) {
				tmp = max(tmp, longest_len[j]);	
				longest_len[i] = tmp + 1;
			}
		}
		ans = max(ans, longest_len[i]);
		tmp = 1;
	}

	cout << ans << '\n';
}