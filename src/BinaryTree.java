import java.util.*;

/**
 * BinaryTree implements a binary tree.
 */
public class BinaryTree<T> 
{
    private BTNode<T> root;

    /**
     * Creates an empty binary tree.
     */
    public BinaryTree()   {
        root = null;
    }

    
    /**
     * Creates a binary tree with the specified element as its root.
     * @param element the object to store in the root node
     */ 
    
    public BinaryTree (T element)    {
        root = new BTNode<T>(element);
    }
    
    /**
     * Creates a binary tree with the two specified subtrees.
     * @param element the object to store in the root node
     * @param left the left subtree that should come off the root node
     * @param right the right subtree that should come off the root node
     */
    public BinaryTree (T element, BinaryTree<T> left, BinaryTree<T> right){
        root = new BTNode<T>(element);
        root.setLeft(left.root);
        root.setRight(right.root);
    }
    
    /**
     * Returns the element stored in the root of the tree.
     * 
     * @return the element stored in the root of the tree
     * @throws RuntimeException if the tree is empty
     */
    public T getRootElement()    {
        if (root == null)
            throw new RuntimeException ("Get root operation "
                + "failed. The tree is empty.");
                
        return root.getElement();
    }

    /**
     * Sets the element stored in the root of the tree.
     * 
     * @param value the object to store in the root
     * @throws RuntimeException if the tree is empty
     */
    public void setRootElement(T value){
        if (root == null)
            throw new RuntimeException ("Get root operation "
                + "failed. The tree is empty.");

        root.setElement(value);
    }

    /**
     * Sets left subtree of the root of the tree.
     * 
     * @param newLeft the tree which is to become the left subtree of the root
     * @throws RuntimeException if the tree is empty
     */
    public void setLeft(BinaryTree<T> newLeft)    {
        if (root == null)
            throw new RuntimeException ("Set left operation "
                + "failed. The tree is empty.");
                
        root.setLeft(newLeft.root);
    }

    /**
     * Sets the right subtree of the root of the tree.
     * 
     * @param newRight the tree which is to become the right subtree of the root
     * @throws RuntimeException if the tree is empty
     */
    public void setRight(BinaryTree<T> newRight)
    {
        if (root == null)
            throw new RuntimeException ("Set right operation "
                + "failed. The tree is empty.");
        root.setRight(newRight.root);
    }

    
    /**
     * Satisfies the Iterable interface using an inorder traversal.
     * 
     */
    public Iterator<T> iterator()
    {
        return inorder();
    }
    
    /****************************************************************************
       ***************************************************************************
     * BELOW ARE THE METHODS THAT YOU NEED TO IMPLEMENT
     *****************************************************************************
      ****************************************************************************/
   
    /**
     * Returns the left subtree of the root of this tree.
     * 
     * @return the left subtree of the root of this tree.
     * @throws RuntimeException if the tree is empty
     */
    public BinaryTree<T> getLeft()    {
        BinaryTree<T> leftSubTree = new BinaryTree<T>();
        
        if (root == null)
        {
            throw new RuntimeException ("Get left operation "
                + "failed. The tree is empty.");
        }
        else
        {
            leftSubTree.root = root.getLeft();
        }
        
        return leftSubTree;
    }

    

    /**
     * Returns the right subtree of the root of this tree.
     * 
     * @return the right subtree of the root of this tree.
     * @throws RuntimeException if the tree is empty
     */
    public BinaryTree<T> getRight()    {
       BinaryTree<T> rightSubTree = new BinaryTree<T>();
       
       if (root == null)
        {
            throw new RuntimeException ("Get right operation "
                + "failed. The tree is empty.");
        }
        else
        {
            rightSubTree.root = root.getRight();
        }
        
        return rightSubTree;
    }


    /**
    * Returns the number of elements in this binary tree.
    * 
    * @return the number of elements in this binary tree
    */ 
    public int size()
    {
        int result = 0;

        result = root.count();

        return result-1;
    }
    
    /**
    * Determines if tree contains any nodes
    * 
    * @return true if no nodes in tree, else false
    */
    public boolean isEmpty()
    {
       boolean empty = false;
       
       if (root==null)
       {
           empty = true;
       }
       
       return empty;
    }

    /**
    * Determines if tree is simply a leaf
    * 
    * @return true if no nodes in tree, else false
    */
    public boolean isLeaf()
    {
       boolean leaf = false;
       
       if (root == null)
        {
            throw new RuntimeException ("Get leaf failed. The tree is empty.");
        }
        else if (root.getRight()==null && root.getLeft()==null)
        {
            leaf = true;
        }
        
        return leaf;
    }

    //-----------------------------------------------------------------
    //  Populates and returns an iterator containing the elements in
    //  this binary tree using an inorder traversal.
    //-----------------------------------------------------------------
    private Iterator<T> inorder()
    {
        ArrayIterator<T> iter = new ArrayIterator<T>();

        root.inorder(iter);

        return iter;
    }
    
    //-----------------------------------------------------------------
    //  Prints all elements in this5 binary tree
    //  using an inorder traversal.
    //-----------------------------------------------------------------
    public void print()
    {
        Iterator<T> iter = inorder();
        
        while(iter.hasNext())
        {
            System.out.println(iter.next());
        }
    }

    //-----------------------------------------------------------------
    //  Finds if an element exists
    //  in this binary tree.
    //-----------------------------------------------------------------
    public BTNode<T> find(T target)
    {
        BTNode<T> result = root.find(target);
        
        if(result!=null)
        {
            System.out.println("Target found: " + result.getElement() + "\n");
        }
        else
        {
            System.out.println("Target not found.\n");
        }
            
        return result;
    }

}
