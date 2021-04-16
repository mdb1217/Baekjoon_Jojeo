//Silver 1 <�ູ ��ġ��> - �׸��� -
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int n, k;
	int h1, h2;
	vector <int> diff;
	int price = 0;

	cin >> n >> k;

	cin >> h1;
	for (int i = 0; i < n - 1; i++) {
		cin >> h2;
		diff.push_back(h2 - h1);
		h1 = h2;
	}

	sort(diff.begin(), diff.end());
	
	for (int i = 0; i < n - k; i++) {
		price += diff[i];
	}

	cout << price << endl;
	
}