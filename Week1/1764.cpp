#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int n, m;
	string str;
	vector <string> not_listen, not_seen, common;
	
	cin >> n >> m;
	
	for(int i=0; i<n; i++) {
		cin >> str;
		not_listen.push_back(str);
	}
	
	for(int i=0; i<m; i++) {
		cin >> str;
		not_seen.push_back(str);
	}
	
	sort(not_listen.begin(), not_listen.end());
	sort(not_seen.begin(), not_seen.end());
	
	int i=0, j=0;
	
	while(i<n && j<m){
		if(not_listen[i] < not_seen[j])
			i++;
		else if(not_listen[i] > not_seen[j])
			j++;
		else{
			common.push_back(not_listen[i]);
			i++; j++;
		}
	}
	
	cout << common.size() << endl;
	for(int i=0; i<common.size(); i++)
		cout << common[i] << endl;
}
