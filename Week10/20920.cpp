//Silver 3 <영단어 암기는 괴로워> - 정렬 -
#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(const pair<int, string>& a, const pair<int, string>& b) {
	if (a.first == b.first) {   //빈도가 같으면, 단어 길이순
		if (a.second.size() == b.second.size()) { //길이가 같으면 사전순
			return a.second < b.second;
		}
		else {
			return a.second.size() > b.second.size();
		}
	}
	else { //빈도 오름차순
		return a.first > b.first;
	}
}

int main() {
	cin.tie(0);
	ios::sync_with_stdio(false);

	int n, len;
	string word;
	map <string, int> words;
	map <string, int>::iterator it;
	vector <pair<int, string> > freqWords;

	cin >> n >> len;

	for (int i = 0; i < n; i++) {
		cin >> word;
		if (word.size() >= len) {
			if (words.find(word) != words.end()) { //있으면
				words[word] += 1;
			}else { //없으면
				words[word] = 1;
			}
		}
	}

	for (it = words.begin(); it != words.end(); it++)
		freqWords.push_back(make_pair(it->second, it->first)); //freq, word

	sort(freqWords.begin(), freqWords.end(), compare);

	for (int i = 0; i < freqWords.size(); i++)
		cout << freqWords[i].second << '\n';
	
	//맵에다가 key,value를 저장하는데 단어, 빈도 이렇게 저장한다.
	//단어가 M보다 짧으면 저장을 하지마!
	// 그럼 단어 중복이 안생김
	//그다음 이걸 벡터에 옮긴다. 빈도, 단어 이렇게 옮겨
	// 벡터를 빈도 순으로 정렬하고 
	// 빈도가 같으면 길이순으로 길이가 같으면 사전순으로 정렬해준다.
	//그다음 second값인 단어를 출력한다.
	//https://www.onlinegdb.com/ryuUiCs1D

}