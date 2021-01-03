#include <iostream>
#include <string>
#include <vector>

using namespace std;

string binsearch(vector<string> list, string key, int left, int right);
vector<string> bubble_sort(vector<string> list, int n);

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

	


	vector<string> answers;		//vector of keys from binsearch (firstNames[i] == secondNames[i])
	answers.clear();	//initializing
	for (int i = 0; i < numOfFirstNames; i++) {
		string answer;
		answer = binsearch(secondNames, firstNames[i], 1, numOfSecondNames);	//index를 자연수로 바꿔줌. index: 0 ~ (numOfSecondNames-1)
		if (answer != "") {				//if the same word exist
			answers.push_back(answer);	//push to answer (not sort yet)
		}
	}
	
	//sort by dictionary
	answers = bubble_sort(answers, answers.size());

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
			right = median - 1;//왼쪽으로 가야하는데 오른쪽으로 감
			//printf("right = %d\n", right);
		}
		else {
			left = median + 1;//오른쪽으로 가야하는데 왼쪽으로 감
			//printf("left = %d\n", left);
		}
	}
	return "";
}

vector<string> bubble_sort(vector<string> list, int n) {
	int i, j;
	string temp;

	for (i = n - 1; i>0; i--) {
		// 0 ~ (i-1)까지 반복
		for (j = 0; j<i; j++) {
			// j번째와 j+1번째의 요소가 크기 순이 아니면 교환
			if (list[j]>list[j + 1]) {
				temp = list[j];
				list[j] = list[j + 1];
				list[j + 1] = temp;
			}
		}
	}
	return list;	//변경 사항 main에서도 적용되어야 함
}