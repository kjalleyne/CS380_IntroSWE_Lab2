class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /**
    * This method prints the values contained in the binary serach tree, starting from the given node, in a pre-order sequence.
    * @param root The given node from previous method call.
    */
   public void preOrderTraversal(Node root){
      if (root == null) return;
      System.out.print(root.value + " ");
      if (root.left != null) preOrderTraversal(root.left);
      if (root.right != null) preOrderTraversal(root.right);
   }

   
   
   /**
    * This method prints the values contained in the binary serach tree, starting from the given node, in an in-order sequence.
    * @param root The given node from previous method call.
    */
   public void inOrderTraversal(Node root){
      if (root == null) return;
      if (root.left != null) inOrderTraversal(root.left);
      System.out.print(root.value + " ");
      if (root.right != null) inOrderTraversal(root.right);
   }
   
   
   
   /**
    * This method prints the values contained in the binary serach tree, starting from the given node, in post-order sequence.
    * @param root The given node from previous method call.
    */
   public void postOrderTraversal(Node root){
      if (root == null) return;
      if (root.left != null) postOrderTraversal(root.left);
      if (root.right != null) postOrderTraversal(root.right);
      System.out.print(root.value + " ");
   }
   
   
   
   /**
    * This method recursively searches the BST for the given key value, starting from the given root node.
    * @param root The given node from the previously method call.
    * @param key The integer value to be found.
    * @return True if the key value is found and false otherwise.
    */
   public boolean find(Node root, int key){

      boolean flag; // declare boolean flag

      if (root == null) flag = false; // If the given node is null then set flag to false

      else if (root.value == key) flag = true; // if the value of the given node is equal to the given key value, then set flag to true

      // This block executes if the given node value is less than the given key value
      else if (root.value < key) {

         /* 
          * If the right node exists, then recursively call this function with that node and the given key value.
          * Otherwise, set flag to false.
          */
         if (root.right != null) {
            flag = find(root.right, key);
         }
         else {
            flag = false;
         }
      }

      // This block executes if the given node value is greater than the given key value
      else {

         /* 
          * If the left node exists, then recursively call this function with that node and the given key value.
          * Otherwise, set flag to false.
          */
         if (root.left != null) {
            flag = find(root.left, key);
         }
         else {
            flag = false;
         }
      }

      // Return flag
      return flag;
   }
   
   
   
   /**
    * This method recursively searches the BST for the minimum value
    * @param root The node given in the previous method call
    * @return The minimum value in the BST
    */
   public int getMin(Node root){

      int min;

      if (root == null) min = Integer.MAX_VALUE;
      else if (root.left != null) min = getMin(root.left);
      else min = root.value;

      return min;

   }
  
  
  
   /**
    * This method recursively searches the BST for the maximum value
    * @param root The node given in the previous method call
    * @return The maximum value in the BST
    */
   public int getMax(Node root){

      int max;

      if (root == null) max = Integer.MIN_VALUE;
      else if (root.right != null) max = getMax(root.right);
      else max = root.value;

      return max;
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}