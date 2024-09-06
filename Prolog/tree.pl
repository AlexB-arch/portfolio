root(v50).
hasLeftChild(v50,v20).
hasRightChild(v50,v70).
hasLeftChild(v20,v10).
hasRightChild(v20,v40).
hasLeftChild(v40,v30).
hasLeftChild(v70,v60).
hasRightChild(v70,v80).
hasRightChild(v80,v90).

/* Predicates */
isParentOf(Parent, Child) :- hasLeftChild(Parent, Child).
isParentOf(Parent, Child) :- hasRightChild(Parent, Child).

siblings(A,B) :- hasLeftChild(A,B), hasRightChild(A,B).

isAncestorOf(Ancestor, Descendant) :-  hasRightChild(Ancestor,Descendant), hasRightChild(Descendant,_).
isAncestorOf(Ancestor, Descendant) :-  hasLeftChild(Ancestor,Descendant), hasLeftChild(Descendant,_).

isGreaterThan(A,B) :- hasLeftChild(A,_) > hasRightChild(_,B).