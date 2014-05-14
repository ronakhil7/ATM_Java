/** 
  * SecretKeyCrypto class
  * Provides methods to:
  *   a) Generate a secret key using the DES algorithm
  *   b) Encrypt a plain-text string with a given key
  *   c) Decrypt a ciphertext string with a given key
  *   d) Convert a secret key to a byte string
  *
  * 
  * @author ASM Sajeev
**/

package atm1844;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.io.*;


public class SecretKeyCrypto {


   /**
    *  Method to generate a DES Key
    *  Input: Nil
    *  Output: A DES secret key
   **/
   public SecretKey getADESKey() {
      SecretKey result = null;
      try {   
         KeyGenerator keygen = KeyGenerator.getInstance("DES");
         result =  keygen.generateKey();
      }
      catch(NoSuchAlgorithmException e) {
         System.out.println("Error in getADESKey: " + e.toString());
      }
     return result;
   }

   
   /** 
    *  Method to encrypt a message
    *  Input:  A message as a byte array and a secret DES key
    *  Output: Corresponding cypher text as a byte array
   **/

   public byte [] encryptUsingDES (byte[] msg, SecretKey k) {
      byte[] ciphertext = null;

      try {
         Cipher myCipher = Cipher.getInstance("DES");  // Create a cipher object
         myCipher.init(Cipher.ENCRYPT_MODE, k);        // Initialise it for encryption

         ciphertext = myCipher.doFinal(msg);           // Encrypt the input msg
      }
      catch (NoSuchAlgorithmException e) {
         System.out.println("Error in encryptUsingDES: " + e.toString());
      }
      catch (InvalidKeyException e) {
         System.out.println("Error in encryptUsingDES: " + e.toString());
      }
      catch (IllegalBlockSizeException e) {
         System.out.println("Error in encryptUsingDES: " + e.toString());
      }
      catch (NoSuchPaddingException e) {
         System.out.println("Error in encryptUsingDES: " + e.toString());
      }
      catch (BadPaddingException e) {
         System.out.println("Error in encryptUsingDES: " + e.toString());
      }
      return ciphertext;                                // Return the encrypted message
   }


   
   /**
    *  Method to decrypt a message
    *  Input:  A ciphert text as a byte array and a secret DES key
    *  Output: The corresponding plaintext as a byte array
   **/
   public byte[] decryptUsingDES (byte[] ciphertext, SecretKey k) {
      
      byte[] message = null;

      /****ADD CODE FOR DECRYPTION HERE **************/
      try {
         Cipher myCipher = Cipher.getInstance("DES");
         myCipher.init(Cipher.DECRYPT_MODE, k);

         message = myCipher.doFinal(ciphertext);
      }
      catch (NoSuchAlgorithmException e) {
         System.out.println("Error in decryptUsingDES: " + e.toString());
      }
      catch (InvalidKeyException e) {
         System.out.println("Error in decryptUsingDES: " + e.toString());
      }
      catch (IllegalBlockSizeException e) {
         System.out.println("Error in decryptUsingDES: " + e.toString());
      }
      catch (NoSuchPaddingException e) {
         System.out.println("Error in decryptUsingDES: " + e.toString());
      }
      catch (BadPaddingException e) {
         System.out.println("Error in decryptUsingDES: " + e.toString());
      }

      return message;
   }


   /* Method to convert a DES Secret Key to a byte array
    * Input: A secret key
    * Returns: A byte array
   **/
   public byte[] convertDESKeyToByteArray(SecretKey k) {

      return k.getEncoded();
   }


   /* Method to convert a key stored as a byte array to a DES Secret Key
    * Input: A secret key represented as a byte array
    * Returns: The corresponding secret key
   **/
   public SecretKey convertByteArrayToDESKey(byte[] keyBytes) {
      SecretKey result = new SecretKeySpec(keyBytes, "DES");
      return result;
   }

}    // SecretKeyCrypto

