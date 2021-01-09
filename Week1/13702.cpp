#include <iostream>
#include <vector>
using namespace std;

int main() {
	int bottle_cnt, k, beer;
	long sum=0;
	long low, mid, high, cup=0;
	long max_beer=0;
	vector <int> bottles;
	
	cin >> bottle_cnt >> k;
	
	for(int i=0; i<bottle_cnt; i++){
		cin >> beer;
		sum += beer;
		bottles.push_back(beer); 
	}
	
	low=0; high = sum/k;
	
	while(low <= high) {
		mid = (low+high)/2; //�����ִ� ���� �뷮 
		if(mid != 0){
			cup=0;
			for(int i=0; i<bottle_cnt; i++) {
				cup += (bottles[i] / mid);
			}
		}
		if(cup < k){
			high = mid-1;	
		}else {
			max_beer = mid; //�ִ� ���� �� 
			low = mid+1;
		}
	}
	cout << max_beer;
}
