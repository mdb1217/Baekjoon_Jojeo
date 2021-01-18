//Silver 1 <Butcher shop> - greedy algorithm -
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int meat_cnt, target_weight, meat_weight, meat_price;
	int ans_price = 0;
	vector <pair<int,int>> meat_list;
	
	cin >> meat_cnt >> target_weight;

	meat_list.push_back(make_pair(0, 0));
	for (int i = 0; i < meat_cnt; i++) {
		cin >> meat_weight >> meat_price;
		meat_list.push_back(make_pair(meat_price, meat_weight));
	}

	sort(meat_list.begin(), meat_list.end()); //first:price, second:weight

	meat_weight = meat_list[0].second;
	ans_price = meat_list[0].first;
	for (int i = 1; i < meat_list.size(); i++) {
		ans_price = meat_list[i].first;
		if (meat_list[i - 1].first == meat_list[i].first) { //같은 가격의 고기 여러개 사는 경우를 고려안함....흑흑
			meat_weight = meat_list[i].second;
		}
		else {
			meat_weight += meat_list[i].second;
		}
		if (meat_weight >= target_weight) {
			break;
		}
	}
	if (meat_weight < target_weight)
		ans_price = -1;
	cout << ans_price << endl;
}