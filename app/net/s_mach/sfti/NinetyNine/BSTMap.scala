package net.s_mach.sfti.NinetyNine
import scala.collection.mutable.ArrayStack
import scala.collection.mutable

/**
 * author:JustinLuk
 * date:3/2/15
 *
 * Learning from Mark Lewis Scala Tutorials
 */

/*
class to create a BST from a map data structure
comp allows a comparator between the values equating to -1,0,1 for less, eq, greater than, respectively
 */
class BSTMap[K,V](comp:(K,K) => Int) extends mutable.Map[K,V] {

  //inner class to create nodes in tree
  class Node(var key: K, var value: V, var left: Node, var right: Node)

  private var root: Node = null;
  def getRoot() = root;
  /*
  @Description: add method using recursion for its ability to walk off the tree and store the last child to be attached to on its stack
  @return Unit
   */
  def +=(kv: (K, V)) = {
    val (key, value) = kv;

    //an iterative version cannot walk off the tree and remember the last child to attach to
    //this recursion keeps the last child on the stack so we can attach easily
    def recur(n: Node): Node = {
      //base case we create a new node after walking off the tree
      if (n == null) new Node(key, value, null, null);
      //3 CASES:
      else {
        val c = comp(key, n.key);
        if (c == 0) {
          n.value = value;
        } else if (c <= 0) {
          n.left = recur(n.left);
        } else {
          n.right = recur(n.right);
        }
        n;
      }
    }
    root = recur(root);
    this;
  }

  /*
  Removal Method
  @Description: Successor is max value of left child
  @Return: Unit
   */
  def -=(key: K) = {

    def recur(n: Node): Node = {
      if (n != null){
        val c = comp(key, n.key);

        if (c == 0) {

          if (n.left == null) n.right
          else if (n.right == null) n.left
          else {
            val (k,v,node) = removeMax(n.left)
            n.left = node
            n.key = k
            n.value = v
            n
          }

        } else if (c <= 0) {
          n.left = recur(n.left)
          n
        } else {
          n.right = recur(n.right)
          n
        }
      } else {
        null
      }
    }

    /*
    Helper function to find successor that will be the greatest node in the left subtree
    Case 1: Found an empty right child, pass back the contents of the new successor
    Case 2: Has a right child so we recurse on that child
     */
    def removeMax(n:Node):(K,V,Node) = {
      if (n.right == null){
        (n.key, n.value, n.left)
      } else {
        val (k,v,node) = removeMax(n.right)
        n.right = node
        (k,v,n)
      }
    }

    root = recur(root)
    this
  }

  /*
  iterative get node method
   */
  def get(key: K): Option[V] = {
    var curr = root;
    //store comparison of key looking for and the current node
    var c = if (curr != null) comp(key, curr.key) else 0

    while (curr != null && c != 0) {
      curr = if (c <= 0) curr.left else curr.right
    }
    if (curr == null) None else Some(curr.value)
  }

    /*
    Iterator utilizing a stack, built to Inorder traversal
     */
  def iterator = new Iterator[(K, V)] {
    val stack = new ArrayStack[Node];
    pushAllLeft(root);

    def next:(K,V) = {
      if (!hasNext) println("The stack is empty :(")
      val ret = stack.pop();
      //grab right child and shove all left children onto the stack
      pushAllLeft(ret.right);
      ret.key -> ret.value;
    }

    def hasNext = !stack.isEmpty;

    def pushAllLeft(n:Node): Unit ={
      if (n!=null){
        stack.push(n);
        pushAllLeft(n.left);
      }
    }

  }

  /*
  INORDER Traversal: left, curr, right
   */
  private def inorder(visit: V => Unit): Unit = {
    def recur(n: Node): Unit = {
      if (n != null) {
        recur(n.left)
        visit(n.value)
        recur(n.right)
      }
    }
    recur(root)
  }

}
