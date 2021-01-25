//Silver 1 <Maze> - BFS -
#include <iostream>
#include <string>
#include<queue>
using namespace std;

int n, m;
int ** maze;

int bfs(int i, int j);

int main() {
	string row_input;

	cin >> n >> m;

	maze = new int *[n];

	for (int i = 0; i < n; i++) {
		maze[i] = new int[m];
		cin >> row_input;
		for (int j = 0; j < m; j++) {
			maze[i][j] = row_input[j] - '0'; //char to int
		}
	}

	cout << bfs(0, 0) << endl;

}

int bfs(int i, int j) {
	//상하좌우
	int dx[4] = { -1, 1, 0, 0 };
	int dy[4] = { 0, 0, -1, 1 };
	queue <pair<int, int>> unvisited;
	unvisited.push({ i, j }); // 시작점 넣기
	
	while (!unvisited.empty()) {
		int x = unvisited.front().first;
		int y = unvisited.front().second;
		unvisited.pop();

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;

			if (maze[nx][ny] == 0)
				continue;

			if (maze[nx][ny] == 1) {
				maze[nx][ny] = maze[x][y] + 1;
				unvisited.push({ nx, ny });
			}
		}
	}

	return maze[n - 1][m - 1];
	
}