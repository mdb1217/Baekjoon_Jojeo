#include <algorithm>
#include <iostream>
#define MAX_N 5000
#define MAX_C 100000000
using namespace std;


int n, c, w;
int weight[MAX_N + 1] = { 0 };
int cnt_weight[MAX_C + 1] = { 0 };


int Search()
{
	if (cnt_weight[c])
		return 1;

	for (int i = 0; i < n; i++) {
		int first = weight[i];
		cnt_weight[first]--;

		for (int j = i + 1; j < n; j++) {
			int second = weight[j];
			cnt_weight[second]--;

			// weight 두 값을 더해서 c와 일치하면
			int sum = first + second;
			if (c == sum)
				return 1;

			// weight 세 값을 더해서 c와 일치하면
			if (c - (first + second) >= 0 && cnt_weight[c - (first + second)])
				return 1;
			else
				cnt_weight[second]++;
		}

		cnt_weight[first]++;
	}

	return 0;
}


int main()
{
	// n: 물건의 개수
	// c: 제시하는 무게
	// w: 물건 각각의 무게

	cin >> n >> c;

	for (int i = 0; i < n; i++) {
		cin >> w;
		weight[i] = w;    // 무게 순서대로 저장
		cnt_weight[w]++;  // 무게 빈도수 저장
	}

	cout << Search() << '\n';

	return 0;
}
