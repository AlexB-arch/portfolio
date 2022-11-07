%Prefix
listprefix([],_).
listprefix([HA|TA],[HB|TB]) :- HA=HB, listprefix(TA,TB).

%Suffix
listsuffix(A,B) :- A=B.
listsuffix(A,[_|TB]) :- listsuffix(A,TB).

%Sublist
listsublist([],_).
listsublist(A,B) :- A=B.
listsublist(A,[_|TB]) :-listsublist(A,TB).
listsublist([HA|TA],[HB|TB]) :- HA=HB, listsublist(TA,TB).
