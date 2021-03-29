#include <iostream>
#define MAX 10000000
using namespace std;


int server[MAX + 1] = { 0 };  // 높이 빈도수 배열


int main()
{
	int n, size;
	cin >> n;
	size = n * n;

	int height;
	unsigned long long sum = 0;  // 컴퓨터 개수 합
	for (int i = 0; i < size; i++) {
		cin >> height;
		sum += height;
		server[height]++;
	}

	unsigned long long half = (sum + 1) / 2;  // 컴퓨터 절반
	unsigned long long working = 0;  // 동작하는 컴퓨터 개수
	height = 0;  // 높이 = 분
	while (working < half) {
		size = size - server[height++];
		working = working + size;
	}

	cout << height << '\n';

	return 0;
}
