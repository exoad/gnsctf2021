#include<bits/stdc++.h>

using namespace std;

string read(string filename) {
  ifstream fin;
  fin.open(filename);
  string r;
  fin >> r;
  return r;
}

int main(void) {
  system("node shashashaSolve.js");

  cout << (read("output.txt") == read("hash2.txt") ? "yes" : "no") << endl;
}