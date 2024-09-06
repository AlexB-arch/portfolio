floor(1).
floor(2).
floor(3).
floor(4).
floor(5).
adjacent(X,Y):- X \= (Y + 1) ,X \= (Y - 1).

building(Arnold,Bob,Charlie,Derek,Elijah) :-    floor(Arnold),
                                                floor(Bob),
                                                floor(Charlie),
                                                floor(Derek),
                                                floor(Elijah),

                                                Arnold<5, Bob>1, Charlie>1, Charlie<5, Arnold>Derek, Charlie>Bob, 
                                                adjacent(Charlie,Bob), adjacent(Elijah,Derek),
                                                Arnold\=Bob, Arnold\=Charlie, Arnold\=Derek, Arnold\=Elijah,
                                                Bob\=Arnold, Bob\=Charlie, Bob\=Derek, Bob\=Elijah,
                                                Charlie\=Arnold, Charlie\=Bob, Charlie\=Derek, Charlie\=Elijah,
                                                Derek\=Bob, Derek\=Charlie, Derek\=Arnold, Derek\=Elijah,
                                                Elijah\=Bob, Elijah\=Charlie, Elijah\=Derek, Elijah\=Arnold.