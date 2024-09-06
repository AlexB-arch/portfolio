#include <iostream>
#include <fstream> 
#include <string> 
using namespace std;

int main()
{
    ifstream fin; 
    #include <sstream> // Include the <sstream> header file

    string filename;
    string codedWords[1000];
    int id;
    stringstream ss[1000];

    cout << "Enter filename: ";
    cin >> filename;

    // Open file using provided filename
    fin.open(filename.c_str()); 

    if( fin.is_open() )
    {
        string nextWord;
        // attempt to read another word from the file
        // if this succeeds, store the word in index i of the array
        // if this fails, the condition evaluates false and the loop end
        for( int i = 0; fin >> codedWords[i]; i++ )
        {
               ss << codedWords[i] << endl;
        }
    }
    // If file didn't open successfully, notify user
    else {
        cout << "Unable to open file\n";
    }

    fin.close();
}