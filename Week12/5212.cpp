//Silver 2 <지구 온난화> - 구현 -
#include <iostream>
#include <vector>
using namespace std;

int main() {
	char map[10][10];
	int dx[4] = { 0, 0, -1, 1 };
	int dy[4] = { -1, 1, 0, 0 };
	int r, c;
	int nx, ny, count = 0;
	int minR, minC, maxR, maxC;
	vector <pair<int, int> > island;

	cin >> r >> c;

	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cin >> map[i][j];
		}
	}

	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			if (map[i][j] == 'X') {
				count = 0;
				for (int k = 0; k < 4; k++) {
					nx = i + dx[k];
					ny = j + dy[k];
					if (nx < 0 || nx >= r || ny < 0 || ny >= c || map[nx][ny] == '.') {
						count++;
					}
				}
				if (count < 3) { //남아있는 섬
					island.push_back({ i, j });
					if (island.size() == 1) {
						minR = i; maxR = i; minC = j; maxC = j;
					}
					if (i < minR)
						minR = i;
					else if (i > maxR)
						maxR = i;
					if (j < minC)
						minC = j;
					else if (j > maxC)
						maxC = j;
				}
			}
		}
	}

	int k = 0;
	for (int i = minR; i <= maxR; i++) {
		for (int j = minC; j <= maxC; j++) {
			if (island[k].first == i && island[k].second == j) {
				if (k < island.size() - 1) {
					k++;
				}
			}
			else {
				map[i][j] = '.';
			}
			cout << map[i][j];
		}
		cout << endl;
	}
}