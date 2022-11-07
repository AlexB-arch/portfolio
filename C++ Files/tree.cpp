#include <cstddef>

template <typename T>
struct Node {
    T data;         // Data held at this node in tree
    Node<T>* left;  // Pointer to left child
    Node<T>* right; // Pointer to right child
};

template <typename T>
struct Tree {
    Node<T>* root; // Pointer to topmost (root) node
};

template <typename T>
void initialize(Tree<T> &t)
{
    t.root = NULL;
}

// This is the recursive destroy function, accepting a Node* argument.
template <typename T>
void destroy(Node<T>* n)
{
    if( n == NULL )
        return;
    
    destroy(n->left);  // Recursively destroy left subtree
    destroy(n->right); // Recursively destroy right subtree
    delete n;          // Delete this node
}

// This is the function called by the user, to destroy a Tree.
// It will call the recursive function, beginning with the root node.
template <typename T>
void destroy(Tree<T> &t)
{
    destroy(t.root);
    t.root = NULL;
}

template <typename T>
void insert(Tree<T> &t, T value)
{
    // Create new node to add to the tree
    Node<T>* newNode = new Node<T>;
    newNode->data  = value;
    newNode->left  = NULL;
    newNode->right = NULL;
    
    if( t.root == NULL ) { // empty tree
        t.root = newNode;
        return;
    }
        
    Node<T>* walker = t.root;
    while( true )
    {
        if( value < walker->data )
        {
            if( walker->left == NULL )
            {
                walker->left = newNode;
                return;
            }
            else
                walker = walker->left;
        }
        else // value >= walker->data
        {
            if( walker->right == NULL )
            {
                walker->right = newNode;
                return;
            }
            else
                walker = walker->right;            
        }
    }
}

// Return depth (level) at which value appears
//    or 0 if value is not in tree
template <typename T>
int contains(Tree<T> &t, T value)
{
    Node<T>* walker = t.root;
    int depth = 1;
    while( walker != NULL )
    {
        if( walker->data == value )
            return depth;
        else if( value < walker->data )
            walker = walker->left;
        else // value >= walker->data
            walker = walker->right;
        depth++;
    }
    return 0;
}