//Silver 3 <���ܾ� �ϱ�� ���ο�> - ���� -
#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(const pair<int, string>& a, const pair<int, string>& b) {
	if (a.first == b.first) {   //�󵵰� ������, �ܾ� ���̼�
		if (a.second.size() == b.second.size()) { //���̰� ������ ������
			return a.second < b.second;
		}
		else {
			return a.second.size() > b.second.size();
		}
	}
	else { //�� ��������
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
			if (words.find(word) != words.end()) { //������
				words[word] += 1;
			}else { //������
				words[word] = 1;
			}
		}
	}

	for (it = words.begin(); it != words.end(); it++)
		freqWords.push_back(make_pair(it->second, it->first)); //freq, word

	sort(freqWords.begin(), freqWords.end(), compare);

	for (int i = 0; i < freqWords.size(); i++)
		cout << freqWords[i].second << '\n';
	
	//�ʿ��ٰ� key,value�� �����ϴµ� �ܾ�, �� �̷��� �����Ѵ�.
	//�ܾ M���� ª���� ������ ������!
	// �׷� �ܾ� �ߺ��� �Ȼ���
	//�״��� �̰� ���Ϳ� �ű��. ��, �ܾ� �̷��� �Ű�
	// ���͸� �� ������ �����ϰ� 
	// �󵵰� ������ ���̼����� ���̰� ������ ���������� �������ش�.
	//�״��� second���� �ܾ ����Ѵ�.
	//https://www.onlinegdb.com/ryuUiCs1D

}