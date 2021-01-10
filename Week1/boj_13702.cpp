#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int n, k;
	long long value, sum = 0;
	vector<int> capacity;

	cin >> n >> k;

	for (int i = 0; i < n; i++) {
		cin >> value;
		sum += value;
		capacity.push_back(value);
	}

	long long low = 0, high = sum / k, mid, cup = 0;

	while (low <= high) {
		mid = (low + high) / 2;

		int num = 0;
		if (mid != 0)
			for (int i = 0; i < n; i++)
				num += capacity[i] / mid;

		if (num >= k) {
			cup = mid;
			low = mid + 1;
		}
		else high = mid - 1;
	}

	cout << cup << '\n';

	return 0;
}