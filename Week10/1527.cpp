//Silver 1 <�ݹμ��� ����> - ���Ʈ���� -
#include <iostream>
#include <queue>
#include <vector>
using namespace std;


int bfs(int a, int b) {
	long long s = 0;
	int cnt = 0;
	int gmNum[2] = { 4, 7 };
	queue <long long> parentNum;
	
	parentNum.push(gmNum[0]);
	parentNum.push(gmNum[1]);

	while(!parentNum.empty()){
		 s = parentNum.front(); //�θ� ����
		 parentNum.pop();
		 if (s >= a && s <= b)
			 cnt++;
		 else if (s > b) {
			 break;
		 }
		 for (int j = 0; j < 2; j++) { //�ڽ� 2���� �ְ�
			 long long child = s * 10 + gmNum[j];
			 parentNum.push(child);
		 }
	}
	return cnt;
}

int main() {
	int a, b;
	
	cin >> a >> b;

	cout << bfs(a, b) << endl;
}