#include<iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <sstream>
#include <queue>
#include <deque>
#include <bitset>
/* - Sarang - */
#include <iterator>
#include <list>
#include <stack>
#include <map>
#include <set>
#include <unordered_set>
#include <unordered_map>
#include <functional>
#include <numeric>
#include <utility>
#include <limits>
#include <time.h>
#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#define ll long long int
#define mod 1000000007
using namespace std;

string FirstNonRepeating(string A){
		    // Code here
		    int n = A.size();
		    vector<int>f(26, 0);
		    vector<int>last(26, -1);
		    for(int i = 0; i < A.size(); i++){
		        if(last[A[i] - 'a'] == -1)
		            last[A[i] - 'a'] = i;
		    }
		    string ans="";
		    for(int i = 0; i < A.size(); i++){
		        f[A[i] - 'a']++;
		        char ch = '#';
		        int x = A.size() + 1;
		        for(int j = 0; j < 26; j++){
		            if(f[j] == 1 and x > last[j]){
		                ch = char(j + 'a');
		                x = last[j];
		            }
		        }
		        ans += ch;
		    }
		    return ans;
		}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout << FirstNonRepeating("aabc");
    return 0;
}