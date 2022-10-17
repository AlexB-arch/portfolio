num(52).
num(29).
num(36).
num(75).
num(24).
num(47).

composite(X,Y) :- Y > 1, 0 is X mod Y.
composite(X,Y) :- Root is sqrt(X), Y < Root, composite(X,Y+1).

composite(N) :- N > 2, composite(N,2).
prime(N) :- not(composite(N)).

/* Sum all items to find average */
sum([],0).
sum([H|T],N) :- sum(T,R),N is H+R.

/* Takes the sum and divide by length of list */
average( List, Average):- 
    sum( List, Sum ),
    length( List, Length),
    Length > 0, 
    Average is Sum/Length.

/*--------------------------------------------------------------------------------------*/
puzzle( Sally, Captain, Tyger, Flame, Newton, Leftover ) :-

                    num(Sally), num(Captain), num(Tyger), num(Flame), num(Newton), num(Leftover),

                    average([52,29,36,75,24,47],Average), 
                    
                    composite(Flame), Flame \= 24, Captain \= 24, 

                    composite(Captain), not(prime(Captain)),

                    composite(Sally,4), composite(Sally,6),

                    Newton \= 24, composite(Newton,13),
                    
                    Tyger > Average,
                    
                    Captain\=Sally, Captain\=Tyger,Captain\=Flame,Captain\=Newton,Captain\=Leftover,
                    Tyger\=Sally,Tyger\=Captain,Tyger\=Flame,Tyger\=Newton,Tyger\=Leftover,
                    Flame\=Sally,Flame\=Captain,Flame\=Tyger,Flame\=Newton,Flame\=Leftover,
                    Newton\=Sally,Newton\=Captain,Newton\=Tyger,Newton\=Flame,Newton\=Leftover.
/*--------------------------------------------------------------------------------------*/