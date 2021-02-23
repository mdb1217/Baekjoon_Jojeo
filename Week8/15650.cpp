//Silver 3 <N과 M(2)> - 백트랙킹 -
#include <iostream>
using namespace std;

int N, M;
int arr[10] = { 0 };
bool used[10] = { 0 };

void comb(int k) {
	if (k == M) {
		for (int i = 0; i < M; i++)
			printf("%d ", arr[i]);
		printf("\n");
		return;
	}
	for (int i = 1; i <= N; i++) {
		if (!used[i]) {
			arr[k] = i;
			used[i] = 1;
			comb(k + 1);
			for(int j = arr[k]+1; j <= N; j++)
				used[j] = 0;
		}
	}
}

int main() {

	cin >> N >> M;

	comb(0);

}