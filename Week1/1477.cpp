//Gold 5 <휴게소 세우기> - 구현 -
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int main() {
	int N, M, L;
	int pos;
	vector <int> restArea;
	int dis, ans = 0;
	int l = 0, r = L;
	int restAreaCnt = 0;

	cin >> N >> M >> L;

	restArea.push_back(0);
	for (int i = 0; i < N; i++) {
		cin >> pos;
		restArea.push_back(pos);
	}
	restArea.push_back(L);

	sort(restArea.begin(), restArea.end());

	while (l <= r) {
		restAreaCnt = 0;
		dis = (l + r) / 2;
		for (int j = 1; j <= N + 1; j++) {		
			restAreaCnt += (restArea[j] - restArea[j-1] - 1) / dis; //간격이 1인 휴게소 사이에는 지을 수 없다! 자기 위치에 이미 있으니까
		}
		if (restAreaCnt <= M) {
			ans = dis;
			r = dis - 1; //무한루프 방지!
		}
		else {
			l = dis + 1;
		}
	}

	cout << ans << endl;
}