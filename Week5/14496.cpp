//Silver 1 <그대, 그머가 되어> - BFS -
#include <iostream>
#include <queue>
using namespace std;

int a, b;
int N;
int ** graph;
int * visited;

int bfs(int x) {
	queue <int> adjacent;

	adjacent.push(x);
	visited[x] = 0;

	while (!adjacent.empty()) {
		int v = adjacent.front();
		adjacent.pop();
		if (v == b) 
			break;
		for (int i = 1; i < N + 1; i++) {
			if (graph[v][i] == 1 && visited[i] == -1) {
				adjacent.push(i);
				visited[i] = visited[v] + 1; //깊이를 증가시키는 방법
			}
		}
	}

	return visited[b];
}

int main() {
	int M;
	int j, k;
	
	cin >> a >> b;
	cin >> N >> M;

	graph = new int* [N + 1];
	visited = new int[N + 1];

	for (int i = 0; i < N + 1; i++) {
		graph[i] = new int[N + 1];
		visited[i] = -1;
		for (int j = 0; j < N + 1; j++) {
			graph[i][j] = 0;
		}	
	}

	for (int i = 0; i < M; i++) {
		cin >> j >> k;
		graph[j][k] = 1;
		graph[k][j] = 1;
	}

	cout << bfs(a) << endl;

}