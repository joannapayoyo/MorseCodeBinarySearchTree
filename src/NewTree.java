import java.io.*;
import java.util.*;
public class NewTree<T>
{
    protected BinaryTree<T> morseTree; //contains morsecode binary search tree (BST)
    private   String[]      fullLine;  //full line as an array on code file
    private   String        line,      //full line on code file
                            letter,    //letter to be added in BST
                            code;      //code to parse through BST

    /**
    * Creates new morsecode binary search tree from a code text file.
    * @param morseTree contains morsecode binary search tree (BST)
    * @param codeFile  scanner for code file to extract morsecode information
    * @return morseTree
    */ 
    public BinaryTree<T> createTree(BinaryTree<T> morseTree, Scanner codeFile) throws IOException
    {
        if(codeFile.hasNext())
        {
            //get next line from code file
            line = codeFile.nextLine();

            //check code
            fullLine = line.split(" ");
            letter = fullLine[0];
            code = fullLine[1];

            //add new node
            morseTree = addNode(morseTree, letter, code);

            //next line on code file
            morseTree = createTree(morseTree, codeFile);
        }

        return morseTree;
    }

    /**
    * Parses through the tree and adds a new node to the BST.
    * @param curTree contains current section of morsecode BST
    * @param letter  letter to be added in BST
    * @param code    code to parse through BST
    * @return curTree
    */ 
    public BinaryTree<T> addNode(BinaryTree<T> curTree, String letter, String code)
    {
        BinaryTree<T> newNode = new BinaryTree<T>((T) letter); //create new node to contain letter
        BinaryTree<T> subTree = curTree;  //holder for newly created subtree

        //finds the appropriate place for new node
        if(code.length()==1 && code.charAt(0)=='.')
        {
            curTree.setLeft(newNode);
        }
        else if(code.length()==1 && code.charAt(0)=='-')
        {
            curTree.setRight(newNode);
        }
        else if(code.length()>1 && code.charAt(0)=='.')
        { 
            subTree=(addNode(curTree.getLeft(), letter, code.substring(1)));
            curTree.setLeft(subTree);
        }
        else if(code.length()>1 && code.charAt(0)=='-')
        {
            subTree=(addNode(curTree.getRight(), letter, code.substring(1)));
            curTree.setRight(subTree);
        }

        return curTree;
    }

    /**
    * Parses through the tree and adds a new node to the BST.
    * @param fileName contains text file of morsecode
    * @return morseTree
    */ 
    public BinaryTree<T> newTree(String fileName) throws IOException
    {
        //initializes the new tree
        Scanner codeFile = new Scanner(new File(fileName));
        morseTree = new BinaryTree<T>((T) "start");
        morseTree = createTree(morseTree, codeFile);

        return morseTree;
    }
}
