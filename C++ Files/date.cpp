#include <iostream>
#include <cassert>
#include "date.h"
using namespace std;

int main()
{
    Date a, b, c, d, e, f, g, h, i, j, k, t;
    a.month =  1; a.day = 30; a.year = 1981;
    t = getTomorrow(a);
    b.month =  1; b.day = 31; b.year = 1981;
    t = getTomorrow(b);
    cout << t << endl;
    assert( t.month ==    2 );
}