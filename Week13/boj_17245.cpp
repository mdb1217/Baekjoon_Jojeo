#include <iostream>
#define MAX 10000000
using namespace std;


int server[MAX + 1] = { 0 };  // ���� �󵵼� �迭


int main()
{
	int n, size;
	cin >> n;
	size = n * n;

	int height;
	unsigned long long sum = 0;  // ��ǻ�� ���� ��
	for (int i = 0; i < size; i++) {
		cin >> height;
		sum += height;
		server[height]++;
	}

	unsigned long long half = (sum + 1) / 2;  // ��ǻ�� ����
	unsigned long long working = 0;  // �����ϴ� ��ǻ�� ����
	height = 0;  // ���� = ��
	while (working < half) {
		size = size - server[height++];
		working = working + size;
	}

	cout << height << '\n';

	return 0;
}
