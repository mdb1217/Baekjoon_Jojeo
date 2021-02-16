//Silver 2 <상자넣기> - dp -
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int n;
	int mem[1001];
	int box[1001] = { 0 };
	int count = 0;
	int comp;

	cin >> n;

	for (int i = 0; i < n; i++)
		mem[i] = 1;

	for (int i = 0; i < n; i++) {
		cin >> box[i];
		comp = 0;
		for (int j = i - 1; j >= 0; j--) {
			if (box[j] < box[i]) { 
				comp = max(mem[j], comp); //이전 모든 것들 중 최대 상자 개수
				
			}
		}
		mem[i] = comp + 1;
		if (count < mem[i])
			count = mem[i];
	}

	cout << count << endl;
}