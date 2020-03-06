import java.util.*;
/**
 * Decode decodes a morse code message using a binary tree.
 */
public class Decode
{
    /**
     * Decodes the given text to letters.
     * @param decodeLine text to decode
     * @param morseTree  tree to search through
     */ 
    public void decode(String decodeLine, BinaryTree morseTree)
    {
        //split line to individual letter codes
        String[] wordArray = decodeLine.split("       "); //splits the message into words
        String[] letterArray; //holder to contain separate letters in message
        
        //translate each word to letters
        for(int c=0; c < wordArray.length; c++)
        {
            letterArray = wordArray[c].split("   ");
            for(int c2=0; c2 < letterArray.length; c2++)
            {
                findLetter(morseTree, letterArray[c2]);
            }
            System.out.print(" ");
        }
        System.out.println();
    }
    
    /**
     * Searches the morsecode BST for the correct letter.
     * @param subTree current subtree to search
     * @param code    code to parse through the BST
     */ 
    public void findLetter(BinaryTree subTree, String code)
    {
        if(code.length()==1 && code.charAt(0)=='.')
        {
            System.out.print(subTree.getLeft().getRootElement());
        }
        else if(code.length()==1 && code.charAt(0)=='-')
        {
            System.out.print(subTree.getRight().getRootElement());
        }
        else if(code.length()>1 && code.charAt(0)=='.')
        { 
            subTree = subTree.getLeft();
            findLetter(subTree, code.substring(1));
        }
        else if(code.length()>1 && code.charAt(0)=='-')
        {
            subTree = subTree.getRight();
            findLetter(subTree, code.substring(1));
        }
    }
}
