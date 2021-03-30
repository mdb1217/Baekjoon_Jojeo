//Silver 2 <서버실> - 이분탐색 -
#include <iostream>
#define MAX 10000000
using namespace std;

int height[MAX + 1] = { 0 }; //컴퓨터 높이 빈도수 배열

int main() {
	int n, h;
	
	int size = 0;
	long long total = 0;
	long long half;
	long long working = 0; //작동하는 컴퓨터
	int min = 0;

	cin >> n;

	size = n * n;

	for (int i = 0; i < size; i++) {
		cin >> h;
		total += h;
		height[h]++;
	}

	half = (total + 1) / 2;

	while (working < half) {
		size -= height[min++]; 
		working += size;
	}

	cout << min << endl;

}