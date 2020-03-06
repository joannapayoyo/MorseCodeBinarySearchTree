import java.util.*;
    public class BTNode<T> 
    {
        protected T element;
        protected BTNode<T> left, right;
        protected int numNodes; //number of nodes in tree

        BTNode<T> result=null;
        //-----------------------------------------------------------------
        //  Creates a new tree node with the specified data.
        //-----------------------------------------------------------------
        public BTNode (T element)
        {
            this.element = element;
            left = right = null;
        }

        //-----------------------------------------------------------------
        //  Returns the element stored in this node.
        //-----------------------------------------------------------------
        public T getElement()
        {
            return element;
        }

        //-----------------------------------------------------------------
        //  Sets the element stored in this node.
        //-----------------------------------------------------------------
        public void setElement (T element)
        {
            this.element = element;
        }

        //-----------------------------------------------------------------
        //  Returns the left subtree of this node.
        //-----------------------------------------------------------------
        public BTNode<T> getLeft()
        {
            return left;
        }

        //-----------------------------------------------------------------
        //  Sets the left child of this node.
        //-----------------------------------------------------------------
        public void setLeft (BTNode<T> left)
        {
            this.left = left;
        }

        //-----------------------------------------------------------------
        //  Returns the right subtree of this node.
        //-----------------------------------------------------------------
        public BTNode<T> getRight()
        {
            return right;
        }

        //-----------------------------------------------------------------
        //  Sets the right child of this node.
        //-----------------------------------------------------------------
        public void setRight (BTNode<T> right)
        {
            this.right = right;
        }

        //-----------------------------------------------------------------
        //  Returns the element in this subtree that matches the
        //  specified target. Returns null if the target is not found.
        //-----------------------------------------------------------------
        public BTNode<T> find (T target)
        {
            
            if(element.equals(target))
            {
                result = new BTNode<T>(element);
            }
            else
            {
                if(left!=null && result==null)
                {
                    result = left.find(target);
                }
                if(right!=null && result==null)
                {
                    result = right.find(target);
                }
            }
            
        
            return result;
        }

        //-----------------------------------------------------------------
        //  Returns the number of nodes in this subtree.
        //-----------------------------------------------------------------
        public int count()
        {
            int leftNumNodes=0,
                rightNumNodes=0;
            
            if(element == null)
            {
                numNodes = 0;
            }
            if(left!=null)
            {
                leftNumNodes = left.count(); 
            }
            if(right!=null)
            {
                rightNumNodes = right.count();
            }
                
            numNodes = 1 + leftNumNodes + rightNumNodes;
            
            return numNodes;
        }

        //-----------------------------------------------------------------
        //  Performs an inorder traversal on this subtree, updating the
        //  specified iterator. This method does not print anything just
        //  performs the traversal
        //-----------------------------------------------------------------
        public void inorder (ArrayIterator<T> iter)
        {
            if(left!=null)
            {
                left.inorder(iter);
            }
            iter.add(element);
            if(right!=null)
            {
                right.inorder(iter);
            }
            
        }
    }