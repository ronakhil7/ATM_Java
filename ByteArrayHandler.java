/** 
  * A collection of methods to handle byte arrays
  * a) print a byte array as hex
  * b) print a byte array as a string
  * c) store a byte array in a file
  * d) read a byte array from a file
  * e) read a string from keyboard and return a byte array
  *
  *
  * @author ASM Sajeev
**/

package atm1844;
import java.io.*;

public class ByteArrayHandler {

   /**
    * Method to read a string from keyboard
    * Returns: the message string as a byte array
   */
   public byte[] readByteArray() {
      String message ="";
      try {
         BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
         System.out.print("Enter the message: ");                // Give a prompt
         message = stdin.readLine();                             // Read the input string
      } catch(IOException e) {
         System.out.println("Error in readByteArray: " + e.toString());
      }

      return message.getBytes();                                 // Convert input to byte array
   }



   /**
    * Methody to display a byte array as a string of hexadecimal numbers
    * Input: a byte array
    *
   */
   public void printByteArrayAsHex(byte[] b) {

      for (int i=0; i<b.length; i++)
        System.out.printf("%x ", b[i]);
      System.out.println();
   }



   /**
    * Method to display a byte array as a string
    * Input: a byte array
    * Warning: If the array contains non-printable characters
    *  the output may not be readable
   */
   public void printByteArrayAsString(byte[] b) {
      System.out.println(new String(b).toString());
   }



   /**
    * Method to save a byte array in a file
    * Input: (1) a byte array, (2) a file name
   */
   public void saveInFile(byte[] b, String fileName) {
      try {
         File aFile = new File(fileName);          // Create a file
         FileOutputStream aFileStream = new FileOutputStream(aFile);
         aFileStream.write(b);
         aFileStream.close();         
      }
      catch (IOException e) {
         System.out.println("Error in saveInFile: " + e.toString());
      }
   }


   /**
    * Method to read a byte array from a file
    * Input: a file name
    * Returns: a byte array
   */
   public byte[] readFromFile(String fileName) throws IOException {

      byte[] result = null;
      
      try {
         File aFile = new File(fileName);          // Access the file
         FileInputStream aFileStream = new FileInputStream(aFile);
         int resultSize = (int) aFile.length();

         result = new byte[resultSize];
         aFileStream.read(result);
         aFileStream.close();
      }
      catch (IOException e) {
         System.out.println("Error in readFromFile: " + e.toString());
      }
      return result;
   }
}  //end ByteArrayHandler
