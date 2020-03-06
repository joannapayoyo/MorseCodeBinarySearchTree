import java.util.*;
import java.io.*;
/**
 * Encode translates a message into morse code message using an array.
 */
public class Encode<T>
{
    private final int TARE_ASCII  = 65, //ascii number of "A"
                      SPACE_ASCII = 32, //ascii number of space
                      NUM_ALPHA   = 26; //number of letters in English
                      
    private String[] fullLine,         //full line in array from the code file
                     encodeArray = new String[NUM_ALPHA]; //initializes the code array for encoding to morse
                      
    private String line,             //full line from the code file
                   letter,           //letter reference of morsecode to be added
                   code;             //morsecode to be added
    private int    ascii;            //ascii value of a letter

    /**
     * Adds morsecodes to morsecode array in alphabetical order.
     * @param fileName contains name of the code file
     */ 
    public void newEncodeArray(String fileName) throws IOException
    {
        Scanner codeFile = new Scanner(new File(fileName));

        while(codeFile.hasNext())
        {
            line = codeFile.nextLine(); //get line from code file
            
            //split line to letter and morsecode
            fullLine = line.split(" ");
            letter   = fullLine[0];
            code     = fullLine[1];
            
            ascii = letter.charAt(0);             //convert letter to ascii
            encodeArray[ascii-TARE_ASCII] = code; //add code to alpha position
        }
    }

    /**
     * Encodes given text to morsecode.
     * @param encodeString text to be encoded into morsecode
     */ 
    public void encode(String encodeString)
    {
        for(int c=0; c < encodeString.length() ; c++)
        {
            ascii = encodeString.charAt(c); //convert letter to ascii
            
            //convert to code if letter
            try 
            {
                if(ascii!=SPACE_ASCII)
                {
                    System.out.print(encodeArray[ascii-TARE_ASCII] + "   ");
                }
                else
                {
                    System.out.print("    ");
                }
            }
            catch(ArrayIndexOutOfBoundsException exception)
            {
                System.out.println("\nERROR FOUND: Only alphabetical values are allowed. Please try again.");
            }
        }
        System.out.println();
    }
}
