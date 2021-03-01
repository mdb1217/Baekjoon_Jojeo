//Silver 2 <소-난다!> - 백트래킹 -
#include <iostream>
using namespace std;

int N, M;
int arr[10] = { 0 };
int num[10] = { 0 };
bool use[10] = { 0 };
bool prime[9001] = { 0 };

void isPrime(int s) {

	for (int i = 2; i*i <= s; i++) {
		if (s % i == 0) {
			return;
		}
	}
	prime[s] = 1;
}

void backtracking(int k) {
	if (k == M) {
		int sum = 0;

		for (int i = 0; i < M; i++) {
			sum += num[arr[i]];
		}
		isPrime(sum);
		return;
	}

	for (int i = 0; i < N; i++) {
		if (use[i] == 0) {
			arr[k] = i;
			use[i] = 1;
			backtracking(k + 1);
			for (int j = arr[k]+1; j < N; j++) {
				use[j] = 0;
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		cin >> num[i];
	}

	backtracking(0);

	bool flag = 0;
	for (int i = 0; i < 9001; i++) {
		if (prime[i]) {
			flag = 1;
			cout << i << endl;
		}	
	}
	if (!flag)
		cout << "-1" << endl;
}