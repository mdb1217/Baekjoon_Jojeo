//Silver 2 <자원캐기> - dp -
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int N, M;
	int crystal[301][301] = { 0 };
	int comp = 0;
	int value;
	int up, left;

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {

			cin >> value;

			up = 0; left = 0;

			if (i - 1 >= 0) { 
				up = crystal[i - 1][j];
			}

			if (j - 1 >= 0) {
				left = crystal[i][j - 1];
			}

			comp = max(up, left);

			if (value)
				comp++;

			crystal[i][j] = comp;
		}
	}

	cout << crystal[N - 1][M - 1] << endl;

}