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

// have to write a method that rotates the chunk bytes as in the original code

void rotateLeft(int i, int arr[]) {
    
}

/*
Old rotate right
  public static int rotateRight(int i, int rot) {
    return (i >>> rot) | (i << (32-rot));
  }

*/

int main(void) {
    int arr[5] = {1832155490, -590512956, 859174627, 1473976589, 892431156};
    solve(arr);
}
