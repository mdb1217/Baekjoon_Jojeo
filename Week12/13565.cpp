//Silver 2 <침투> - 그래프이론 -
#include <iostream>
#include <string>
#include <queue>
using namespace std;

int r, c;
int map[1000][1000] = { 0 };
bool visit[1000][1000] = { 0 };

bool bfs(int k) {
	queue <pair<int, int> > visited;
	int dx[4] = { 0, 0, -1, 1 };
	int dy[4] = { -1, 1, 0, 0 };
	bool high = 0;

	visited.push({ 0, k });
	visit[0][k] = 1;

	while (!visited.empty()) {
		int x = visited.front().first;
		int y = visited.front().second;
		if (x == r - 1) {
			high = 1;
			return high;
		}
		visited.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
				if (map[nx][ny] == 0 && visit[nx][ny] == 0) {
					visited.push({ nx, ny });
					visit[nx][ny] = 1;
				}
			}
		}
	}

	return high;

}

int main() {		
	bool high = 0;
	string row;

	cin >> r >> c;

	for (int i = 0; i < r; i++) {
		cin >> row;
		for (int j = 0; j < c; j++) {
			map[i][j] = row[j] - '0';
		}
	}

	for (int i = 0; i < c; i++) {
		if (map[0][i] == 0) {
			high = bfs(i);
			if (high)
				break;
		}
	}

	if (high)
		cout << "YES\n";
	else
		cout << "NO\n";
}