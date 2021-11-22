/*
Project 1 Part A Comparable Object Binary Search Tree
Name: Matthew Murillo
*/
public class myBST <T extends Comparable<T>>{

    private BSTnode<T> root; // member variable

    // constructor
    public myBST(){
        root = null;
    }

    //*** Member Methods ***

    //isEmpty method returns true if root is empty
    public boolean isEmpty(){
        return root == null;
    }

    //Insert Method to insert comparable object to object tree
    public void insert(T temp){
        this.root = insertRec(temp, this.root);
    }

    //recursive Insert method which goes through each node until reaches null.
    private BSTnode<T> insertRec(T object, BSTnode<T> t){
        if(t == null) t = new BSTnode<>(object); // create new node if null
        else{
            if(t.data.compareTo(object) >= 0) t.left = insertRec(object, t.left); // root is greater or equal than other
            else t.right = insertRec(object, t.right);//root is less than other
        }
        return t; // return node with change
    }

    //find minimum data function using recursive function
    public T findMin(){
        if(isEmpty()) throw new IllegalArgumentException("Binary Tree is Empty");
        return findMinRec(this.root);
    }

    //recursive function going through every node on left till it's null
    private T findMinRec(BSTnode<T> node){
        if(node.left == null) return node.data;
        else findMinRec(node.left);
        return null;
    }

    //find maximum data function using recursive function
    public T findMax(){
        if(isEmpty()) throw new IllegalArgumentException("Binary Tree is Empty");
        return findMaxRec(this.root);
    }

    //recursive function by going through the right node till it's null
    public T findMaxRec(BSTnode<T> node){
        if(node.right == null) return node.data;
        else findMaxRec(node.right);
        return null;
    }

    //search function to search for a data if it's in the BST
    public T search(T data){
        if(isEmpty()) throw new IllegalArgumentException("Binary Tree is Empty");
        return searchRec(this.root, data);
    }

    //recursive function to check if the given data is equal to the node data
    private T searchRec(BSTnode<T> node, T data){
        if(node.data.compareTo(data) == 0 && node.data.equals(data)) return node.data;
        else{
            if(node.data.compareTo(data) >= 0) searchRec(node.left, data);
            else searchRec(node.right, data);
        }
        return null; // return null if not found
    }

    //delete function to remove a node from the BST using a recursive function
    public void delete(T data){
        if(isEmpty()) throw new IllegalArgumentException("Binary Tree is Empty");
        this.root = this.deleteRec(this.root, data);
    }

    //recursive function to search the function then remove it using different cases
    private BSTnode<T> deleteRec(BSTnode<T> node, T data){
        if(node.data.compareTo(data) == 0 && node.data.equals(data)){ //data has been found
            if(node.left == null) return node.right; //node is now the right of the node
            else if(node.right == null) return node.left; // node is now the left of the node
            else{//both left and right is not null
                node.data = findMinRec(node.right);//find minimum of right side of bst and replace data with it
                node.right = deleteRec(node.right, node.data); // remove minimum of right side of bst
            }
        }
        else{//data has not been found
            if(node.data.compareTo(data) >= 0) node.left =  deleteRec(node.left, data);
            else node.right = deleteRec(node.right, data);
        }
        return node; // return node
    }

    //function to call the inOrderFill function with an array given
    public void sortToArray(Comparable<T>[] array){
        if(isEmpty()) throw new IllegalArgumentException("Binary Tree is Empty");
        inOrderFill(root, array, 0);
    }

    // recursive function to fill the array using inOrder style. Position is added by one when filled
    private int inOrderFill(BSTnode<T> node, Comparable<T>[] arr, int position){
        if(position >= arr.length) throw new IllegalArgumentException("array given is too small to fit all items"); // array given is small
        else {
            if (node.left != null) position = inOrderFill(node.left, arr, position);
            arr[position++] = node.data;
            if (node.right != null) position = inOrderFill(node.right, arr, position);
            return position;
        }
    }
}

//Binary search tree class
class BSTnode <T extends Comparable<T>>{
    //Member variable
    T data;
    BSTnode<T> left, right;

    //Constructor
    public BSTnode(T d){
        data = d;
        left = null;
        right = null;
    }
}
