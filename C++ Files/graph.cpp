Graph<T>
 # T is the data type of graph vertex labels (typically, string or int)

void initialize(Graph<T>& g, bool directed)
 # initializes the graph g, sets flag for directed or undirected graph
 # if you do not specify, the graph will default to undirected

void destroy(Graph<T>& g)
 # destroys the graph g

bool hasVertex(Graph<T> g, T label)
 # returns Boolean indicating whether or not vertex label exists in graph g

void addVertex(Graph<T>& g, T label)
 # adds a vertex with label label into the graph g
 # there is no effect if this vertex already exists

bool hasEdge(Graph<T> g, T source, T dest)
 # returns Boolean indicating whether or not an edge exists source->dest

int getEdgeWeight(Graph<T> g, T source, T dest)
 # returns the weight of the edge source->dest or zero, if no such edge

void addEdge(Graph<T> g, T source, T dest, int weight)
 # adds an edge source->dest with weight weight in graph g
 # the edge weight must be a positive integer number; if not specified, it defaults to weight 1
 # if the graph is undirected, also adds an edge dest->source
 # there is no effect if this edge already exists

void removeEdge(Graph<T> g, T source, T dest)
 # removes edge source->dest from graph g
 # if the graph is undirected, also removes edge dest->source
 # there is no effect if this edge does not exist

int shortestPath(Graph<T> g, T source, T dest)
 # returns the cost of the shortest available path from source->dest
 # returns 0 if no path is available

Queue<T> adjacentTo(Graph<T> g, T label)
 # returns a Queue containing the labels of all graph vertices that are
 #   "adjacent" to vertex label (reachable in one step)
