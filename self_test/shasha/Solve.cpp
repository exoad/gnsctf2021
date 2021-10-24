#include<bits/stdc++.h>

using namespace std;

int main(void) {
  ifstream fin;
  fin.open("output.txt");
  string original;
  fin >> original;

  fin.open("has2.txt");
  string alter;
  fin >> alter;

  cout << (original == alter ? "yes" : "no") << endl;
}