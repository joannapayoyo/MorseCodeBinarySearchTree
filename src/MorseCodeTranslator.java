import java.io.*;
import java.util.*;
public class MorseCodeTranslator<T>
{
    public static void main(String [] args) throws IOException
    {
        //initialize morse code binary tree
        NewTree create = new NewTree();
        BinaryTree morseTree = create.newTree("./src/codes.txt");
        
        //initialize morse code array for encoding
        Encode encode = new Encode();
        encode.newEncodeArray("./src/codes.txt");
        
        //initialize decoder
        Decode decode = new Decode();
        
        //initialize user input for menu
        Scanner input = new Scanner(System.in);
        String  userInput;
        boolean menuExit = false;
        
        System.out.println(
            "+------------------------------------------+\n" +
            "+------------------------------------------+\n" +
            "+---Welcome to the Morse Code Translator---+\n" +
            "+------------------------------------------+\n" +
            "+------------------------------------------+\n");
        
        //initialize menu
        while(menuExit != true)
        {
            menu();
            
            userInput = input.nextLine().toUpperCase();
            
            switch(userInput)
            {
                case "D":
                    System.out.print("\nEnter the morse to decode: ");
                    decode.decode(input.nextLine(), morseTree);
                    break;
                case "E":
                    System.out.print("\nEnter the message to encode: ");
                    encode.encode(input.nextLine().toUpperCase());
                    break;
                case "X":
                    menuExit = true;
                    break;
            }
        }
        
        System.out.println("\nThank you for using the Morse Code Translator :D");
    }
    
    public static void menu()
    {
        System.out.println("\nPlease choose one of the following:");
        System.out.println(
            "D - Decode a morse code message.\n" +
            "E - Encode a message into morse code.\n" +
            "X - Exit the translator."
            );
    }
}
