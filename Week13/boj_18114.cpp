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

			// weight �� ���� ���ؼ� c�� ��ġ�ϸ�
			int sum = first + second;
			if (c == sum)
				return 1;

			// weight �� ���� ���ؼ� c�� ��ġ�ϸ�
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
	// n: ������ ����
	// c: �����ϴ� ����
	// w: ���� ������ ����

	cin >> n >> c;

	for (int i = 0; i < n; i++) {
		cin >> w;
		weight[i] = w;    // ���� ������� ����
		cnt_weight[w]++;  // ���� �󵵼� ����
	}

	cout << Search() << '\n';

	return 0;
}
