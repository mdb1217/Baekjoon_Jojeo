//Silver 1 <영역구하기> - 그래프탐색 -
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

int M, N;
int grid[110][110] = { 0 };

int bfs(int i, int j) {
	queue <pair<int, int>> adj;
	int count = 0;
	int dx[4] = {-1, 1, 0, 0};
	int dy[4] = {0, 0, -1, 1};

	adj.push({ i, j });
	grid[i][j] += 1;
	count++;

	while (!adj.empty()) {
		int x = adj.front().first;
		int y = adj.front().second;
		adj.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
				if (grid[nx][ny] == 0) {
					adj.push({ nx, ny });
					grid[nx][ny] = grid[x][y] + 1;
					count++;
				}
			}
		}
	}

	return count;
}

int main() {
	int square;
	int area_cnt = 0;
	vector <int> area;

	cin >> M >> N >> square;

	for (int i = 0; i < square; i++) {
		int lx, ly, rx, ry;
		cin >> lx >> ly >> rx >> ry;
		for (int j = M-ry; j < M-ly; j++) {
			for (int k = lx; k < rx; k++) {
				grid[j][k] = 1;
			}
		}
	}

	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (!grid[i][j]) {
				area.push_back(bfs(i, j));
				area_cnt++;
			}
		}
	}

	sort(area.begin(), area.end());

	cout << area_cnt << endl;
	for (int i = 0; i < area.size(); i++)
		cout << area[i] << " ";
	cout << endl;

}