#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#define MAX 1000
using namespace std;


vector<int> graph[MAX + 1];
int visited_dfs[MAX + 1];
int visited_bfs[MAX + 1];


void dfs(int v)
{
	visited_dfs[v] = 1;
	cout << v << ' ';

	for (int i = 0; i < graph[v].size(); i++) {
		int next = graph[v][i];
		if (!visited_dfs[next])
			dfs(next);
	}
}


void bfs(int v)
{
	visited_bfs[v] = 1;

	queue<int> q;
	q.push(v);

	while (!q.empty()) {
		v = q.front();
		q.pop();
		cout << v << ' ';
		for (int i = 0; i < graph[v].size(); i++) {
			int next = graph[v][i];
			if (!visited_bfs[next]) {
				visited_bfs[next] = 1;
				q.push(next);
			}
		}
	}
}


int main()
{
	int n, m, v;

	cin >> n >> m >> v;

	for (int i = 0; i < m; i++) {
		int u, w;
		cin >> u >> w;
		graph[u].push_back(w);
		graph[w].push_back(u);
	}

	for (int i = 0; i < n; i++)
		sort(graph[i].begin(), graph[i].end());

	dfs(v);
	cout << '\n';
	bfs(v);

	return 0;
}