#include <iostream>
#include <fstream>
#include "p2heap.h"
using namespace std;

int main()
{
    ifstream fin;
    ofstream fout;

    Heap<string> h;

    initialize(h);

    string ifile, ofile, word;

    cout << "Input filename:  ";
    cin >> ifile;
    cout << "Output filename: ";
    cin >> ofile;    

    fin.open(ifile.c_str());
    int count = 0;
    while( fin >> word )
    {
        put(h,word);
        count++;
    }
    fin.close();

    cout << endl;
    cout << count << " words read from file.\n";
    
    fout.open(ofile.c_str());
    while( ! isEmpty(h) )
    {
        fout << get(h) << endl;
    }
    fout.close();

    cout << endl;
    cout << "Sorted list saved to file " << ofile << endl;

    destroy(h);
}