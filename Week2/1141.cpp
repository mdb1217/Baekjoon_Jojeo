#include <iostream>
#include <vector>
#include <string.h>
#include <algorithm>
using namespace std;

bool comp(string a, string b) { //길이순 정렬
	if(a.length() != b.length())
		return a.length() < b.length();
	else
		return a < b;
}

int main() {
	int n=0;
	string word;
	int prefix=0;
	vector <string> non_prefix;
	
	cin >> n;
	
	for(int i=0; i<n; i++){
		cin >> word;
		non_prefix.push_back(word);
	}
	
	sort(non_prefix.begin(), non_prefix.end(), comp);
	
	bool pre=0;
	for(int i=0; i<n-1; i++){
		pre=0;
		for(int j=i+1; j<n; j++){
			if(non_prefix[j].find(non_prefix[i], 0) == 0){
				pre=1;
				break;
			}
		}
		if(pre)
			prefix++;
	} 
	cout << n-prefix;
}
