#include <iostream>
#include <string>
#include <vector>
#include <string.h>

using namespace std;

string binsearch(vector<string> list, string key, int left, int right);
void qsort(vector<string>& list, int start, int final);

int main(void) {

	string stringBuffer;	//Input Buffer
	getline(cin, stringBuffer, ' ');	//getline to Buffer //before ' '
	char * numOfFirst = new char[stringBuffer.size() + 1];	//first number string (split from cin)
	strcpy (numOfFirst, stringBuffer.c_str());

	getline(cin, stringBuffer, '\n'); //getline to Buffer //before '\n'
	char * numOfSecond = new char[stringBuffer.size()];	//second number string (split from cin)
	strcpy(numOfSecond, stringBuffer.c_str());

	int numOfFirstNames, numOfSecondNames;	//convert number string into integer
	numOfFirstNames = stoi(numOfFirst);
	numOfSecondNames = stoi(numOfSecond);


	vector<string> firstNames;	//vector of first Names
	firstNames.clear();		//initializing
	for (int i = 0; i < numOfFirstNames ; i++) {
		getline(cin, stringBuffer, '\n');
		firstNames.push_back(stringBuffer);
		//cout << stringBuffer << " ";
	}

	

	vector<string> secondNames;	//vector of second Names
	secondNames.clear();	//initializing
	for (int i = 0; i < numOfSecondNames; i++) {
		getline(cin, stringBuffer, '\n');
		secondNames.push_back(stringBuffer);
		//cout << stringBuffer << " ";
	}

	//sort by dictionary
	
	qsort(firstNames, 0, numOfFirstNames-1);	//put index
	qsort(secondNames, 0, numOfSecondNames-1);	//put index


	vector<string> answers;		//vector of keys from binsearch (firstNames[i] == secondNames[i])
	answers.clear();	//initializing
	for (int i = 0; i < numOfFirstNames; i++) {
		string answer;
		answer = binsearch(secondNames, firstNames[i], 0, numOfSecondNames-1);	// index: 0 ~ (numOfSecondNames-1)
		if (answer != "") {				//if the same word exist
			answers.push_back(answer);	//push to answer (not sort yet)
		}
	}
	

	//output
	cout << answers.size() << endl;
	for (int i = 0; i < answers.size(); i++)
	{
		cout << answers[i] << endl;
	}


/*
	char * firstNames = new char[numOfFirstNames];
	char * secondNames = new char[numOfSecondNames];

	for (int i = 0; i < numOfFirstNames; i++)
	{
		std::cin >> firstNames[i];
	}

	for (int i = 0; i < numOfSecondNames; i++)
	{
		std::cin >> secondNames[i];
	}
	*/
}

string binsearch(vector<string> list, string key, int left, int right) {
	int median;
	while (left <= right) {
		median = (left + right) / 2;
		//printf("med = %d\n", median);
		if (list[median] == key) {
			return list[median];
		}
		if (list[median] > key) {
			right = median - 1;//�������� �����ϴµ� ���������� ��
			//printf("right = %d\n", right);
		}
		else {
			left = median + 1;//���������� �����ϴµ� �������� ��
			//printf("left = %d\n", left);
		}
	}
	
	return "";
}
/*
void merge(vector<string>& list, int start, int final, int medium) {	// start index, final index, medium index
	vector<string> ret;		//temp�� ���� ���
	int i = start, j = medium + 1, copy = 0;

	//�迭 �� �� �ݺ�
	while (i <= medium && j <= final) {		//start ~ medium, medium ~ final
		if (list[i] < list[j]) {		//�ùٸ� ������ ��
			ret.push_back(list[i++]);	//�տ� ���� ret�� ���� & i++
		}
		else if (list[i] > list[j]) {	//���� �ٲ���� ��
			ret.push_back(list[j++]);	//�ڿ� ���� ret�� ���� & j++
		}
	}
	
	//�迭 �� �� �ݺ� �� push �ȵ� ���� �� ó��
	while (i <= medium) ret.push_back(list[i++]);	//���� �� ret�� ����
	while (j <= final) ret.push_back(list[j++]);	//���� �� ret�� ����

	//ret -> ���� ����
	for (int k = start; k <= final; k++) {
		list[k] = ret[copy++];		//k�� ���� �迭 index, copy�� ���纻 �迭 index
	}
	//�μ� list�� �ڷ����� �������̹Ƿ� (&) ���� ������ ���� ����
}

void mergeSort(vector<string>& list, int start, int final) {
	if (start < final) {	//index valid value ���� Ȯ��
		int medium = (start + final) / 2;	//setting medium index
		
		//list will be divided into 2
		mergeSort(list, start, medium);		//recall
		mergeSort(list, medium + 1, final);		//recall

		//merge & sort
		merge(list, start, final, medium);
	}
	
}
*/
void qsort(vector<string>& list, int start, int final) {
	string pivot = list[start];
	int bs = start, be = final;
	while (start < final) {		//until switch start and final
		while (pivot <= list[final] && start < final) {
			final--;
		}
		if (start > final) break;
		while (pivot >= list[start] && start < final) {
			start++;
		}
		if (start > final) break;
		swap(list[start], list[final]);
	}
	swap(list[bs], list[start]);
	if (bs < start) {
		qsort(list, bs, start - 1);
	}
	if (be > final) {
		qsort(list, start + 1, be);
	}
}
