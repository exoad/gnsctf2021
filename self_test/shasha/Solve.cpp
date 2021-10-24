#include<bits/stdc++.h>

using namespace std;

int main(void) {
  system("node shashashaSolve.js");
  ifstream fin;
  fin.open("output.txt");
  string original;
  fin >> original;

  fin.open("hash2.txt");
  string alter;
  fin >> alter;

  cout << (original == alter ? "yes" : "no") << endl;

  fin.close();
}