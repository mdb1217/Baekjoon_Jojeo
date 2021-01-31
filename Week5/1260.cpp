//Silver 2 <DFS & BFS> - DFS & BFS -
#include <iostream>
#include<queue>
using namespace std;

int N;
int ** graph;
int * visited;

void dfs(int x) {
	visited[x] = 1;
	cout << x << " ";
	
	for (int i = 1; i < N + 1; i++) {
		if (graph[x][i] == 1 && visited[i] == 0) {
			dfs(i);
		}
	}
}

void bfs(int x) {
	queue <int> adjacent;
	adjacent.push(x);
	visited[x] = 1;
	cout << x << " ";

	while (!adjacent.empty()) {
		int n = adjacent.front();
		adjacent.pop();
		for (int i = 1; i < N + 1; i++) {
			if (graph[n][i] == 1 && visited[i] == 0) {
				adjacent.push(i);
				visited[i] = 1;
				cout << i << " ";
			}
		}
	}
}

int main() {
	int M, start_v;
	int j, k;

	cin >> N >> M >> start_v;

	graph = new int *[N + 1];
	visited = new int[N + 1];

	for (int i = 0; i < N + 1; i++) {
		visited[i] = 0;
		graph[i] = new int[N + 1];
		for (int j = 0; j < N + 1; j++)
			graph[i][j] = 0;
	}

	for (int i = 0; i < M; i++) {
		cin >> j >> k;
		graph[j][k] = 1;
		graph[k][j] = 1;
	}

	dfs(start_v);
	cout << endl;

	for (int i = 0; i < N+1; i++) {
		visited[i] = 0;
	}

	bfs(start_v);

	for (int i = 0; i < N+1; ++i) { 
		delete[] graph[i]; 
	} 

	delete[] graph;
	delete[] visited;
}