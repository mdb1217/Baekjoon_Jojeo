//Silver 3 <N�� M(1)> - ��Ʈ��ŷ -
#include <iostream>
using namespace std;

int N, M;
int p[10] = { 0 };
bool used[10] = { 0 };

void permutation(int k) {
	if (k == M) {
		for (int i = 0; i < M; i++) {
			cout << p[i] << ' ';
			//printf("%d ", p[i]);
		}
		cout << '\n';
		//printf("\n");
		return;
	}
	for (int i = 1; i <= N; i++) {
		if (!used[i]) {
			p[k] = i;
			used[i] = 1;
			permutation(k + 1);
			used[i] = 0;
		}
	}
}

int main() {
	//https://codecollector.tistory.com/381

	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> N >> M;

	permutation(0);
}