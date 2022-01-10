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

int partition(char arr[], int low, int high, char pivot) {
	    int i = low;
	    char temp1, temp2;
	    for (int j = low; j < high; j++) {
	        if (arr[j] < pivot) {
	            temp1 = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp1;
	            i++;
	        } else if (arr[j] == pivot) {
	            temp1 = arr[j];
	            arr[j] = arr[high];
	            arr[high] = temp1;
	            j--;
	        }
	    }
	    temp2 = arr[i];
	    arr[i] = arr[high];
	    arr[high] = temp2;


	    return i;
	}

	void matchPairsUtil(char *nuts, char *bolts, int low, int high) {
	    if (low < high) {
	        int pivot = partition(nuts, low, high, bolts[high]);

	        partition(bolts, low, high, nuts[pivot]);

	        matchPairsUtil(nuts, bolts, low, pivot - 1);
	        matchPairsUtil(nuts, bolts, pivot + 1, high);
	    }
	}

	void matchPairs(char nuts[], char bolts[], int n) {
	    matchPairsUtil(nuts, bolts, 0, n - 1);
	}

int main() {
    int n = 5;
    char nuts[] = {'@', '%', '$', '#', '^'};
    char bolts[] = {'%', '@', '#', '$', '^'};
    matchPairs(nuts, bolts, n);

    for (auto &x: nuts)
        cout << x << " ";
    cout << endl;
    for (auto &x: bolts)
        cout << x << " ";
    cout << endl;

    return 0;
}