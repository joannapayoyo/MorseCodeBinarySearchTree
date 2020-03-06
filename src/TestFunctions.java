import java.io.*;
import java.util.*;
public class TestFunctions
{
    public static void main(String [] args) throws IOException
    {
        //initialize morse code binary tree
        NewTree create = new NewTree();
        BinaryTree morseTree = create.newTree("./src/codes.txt");
        
        //initialize user input
        Scanner input = new Scanner(System.in);
        char  userInput;
        
        //test print and iterator function
        System.out.println(
            "+---------------------------------------+\n" +
            "+----------Iterator/Print Test----------+\n" +
            "+---------------------------------------+\n");
        morseTree.print();
            
        //test find function
        System.out.println(
            "+---------------------------------------+\n" +
            "+---------------Find Test---------------+\n" +
            "+---------------------------------------+\n");
        System.out.print("Enter target object: ");
        morseTree.find(input.nextLine().toUpperCase());
        
        //test isLeaf function
        System.out.println(
            "+---------------------------------------+\n" +
            "+--------------isLeaf Test--------------+\n" +
            "+---------------------------------------+\n");
        if(morseTree.isLeaf())
        {
            System.out.println("This tree is a leaf.");
        }
        else
        {
            System.out.println("This tree is not a leaf.");
        }
    }
}
