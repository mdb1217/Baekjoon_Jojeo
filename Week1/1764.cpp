#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	vector <string> vl;
	vector <string> vs;
	int n, m=0;
	cin >> n >> m;
	int count=0;
	vector <string> vls;
	string tmp;
	
	for(int i=0; i<n; i++) {
		cin >> tmp;
		vl.push_back(tmp);
	}
	for(int i=0; i<m; i++) {
		cin >> tmp;
		vs.push_back(tmp);
	}
	sort(vl.begin(), vl.end());
	sort(vs.begin(), vs.end());
	
	int t=0;
	for(int i=0; i<m; i++) {
		if(t > n-1)
			break;
		if(vl[t] > vs[i]){
			continue;
		}
		else if(vl[t] < vs[i]){
			t++;
		}else{
			count++;
			vls.push_back(vs[i]);
			t++;
		}
	}
	
	cout << count << endl;
	for(int i=0; i<count; i++)
		cout << vls[i] << endl;
}
