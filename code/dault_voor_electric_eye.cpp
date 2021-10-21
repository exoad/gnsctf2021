#include<bits/stdc++.h>

using std::cout;
using std::endl;

void solve(int arr[]) {
    for(int i = 0; i < 5; i++) {
        cout << (char) ((arr[i] & 4278190080) >> 24);
        cout << (char) ((arr[i] & 16711680) >> 16);
        cout << (char) ((arr[i] & 65280) >> 8);
        cout << (char) ((arr[i] & 255));
        cout << endl;
    }
}

int main(void) {
    int arr[5] = {1832155490, -590512956, 859174627, 1473976589, 892431156};
    solve(arr);
}
