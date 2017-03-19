import java.util.Scanner;

public class CaesarCipher {

	public static Scanner scanner = new Scanner(System.in);

	/**
	 * @param data
	 * @param key
	 * @return
	 */
	// Function call for Encryption
	public static String Encrypt(String data, int key) throws Exception{

		String cipher="";
		
		for (int i = 0; i < data.length(); i++) {
			char c = data.charAt(i);
			char shift = Character.isUpperCase(c) ? 'A' : 'a';

			// Get the difference in number from ASCII World
			char shifted = (char) (c - shift);
			// rotate the letter for >=26
			shifted = (char) ((shifted + key) % 26);
			// shift again to ASCII
			cipher += (char) (shifted + shift);
		}
		System.out.println("Encryption (Plain Text to Cipher Text): "+cipher);
		return cipher;
			
	}

	/**
	 * @param data
	 * @param key
	 */
	// Function call for decryption 
	public static void Decrypt(String data, int key) throws Exception{
		
		String plaintext="";
		
		for (int i = 0; i < data.length(); i++) {
			char c = data.charAt(i);
			char shift = Character.isUpperCase(c) ? 'A' : 'a';

			// Get the difference in number from ASCII World
			char shifted = (char) (c - shift);
			// rotate the letter for >=26
			shifted = (char) ((shifted - key) % 26);
			// shift again to ASCII
			plaintext +=(char) (shifted + shift);
		}
		System.out.println("Decryption (Cipher Text to Plain Text): "+plaintext);

	}
}
