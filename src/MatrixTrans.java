
public class MatrixTrans {

	public static final String DELIMETER = "%";

	/**
	 * @param text
	 * @param key
	 * @return
	 */
	// Function call for Encryption
	public static String Encrypt(String text, String key) throws Exception{

		int keyLength = key.length();
		String correctedText = MatrixTrans.correctedString(text, key);
		int textLength = correctedText.length();
		int index = 0;
		String cipher ="";

		String[][] matrix = new String[textLength / keyLength][keyLength];

		for (int i = 0; i < textLength / keyLength; i++) {
			for (int j = 0; j < keyLength; j++) {
				matrix[i][j] = correctedText.charAt(index)+"";
				index++;
			}
		}
		
		for (int i = 0; i <  key.length(); i++) {
			for (int j = 0; j <(textLength / keyLength); j++) {
				cipher += matrix[j][Integer.parseInt(key.charAt(i)+"")-1];
			}
		}
		System.out.println("Encryption (Plain Text to Cipher Text): "+cipher);

		return cipher;
	}

	/**
	 * @param text
	 * @param key
	 */
	//Function call for Decryption
	public static void Decrypt(String text, String key) throws Exception{

		int keyLength = key.length();
		int textLength = text.length();

		String[][] matrix = new String[textLength / keyLength][keyLength];
		int index = 0;
		for (int i = 0; i < key.length(); i++) {
			for (int j = 0; j < textLength / keyLength; j++) {
				matrix[j][Integer.parseInt(key.charAt(i) + "") - 1] = text.charAt(index) + "";
				index++;
			}
		}

		System.out.print("Decryption (Cipher Text to Plain Text): ");

		for (int i = 0; i < textLength / keyLength; i++) {
			for (int j = 0; j < key.length(); j++) {
				if (!matrix[i][j].equals(DELIMETER)) {
					System.out.print(matrix[i][j]);
				} else {
					System.out.print(" ");
				}
			}
		}
	}
	
	/**
	 * @param text
	 * @param key
	 * @return
	 */
	
	// Key needs to be corrected so as to perform the encryption with each alphabet
	public static String correctedString(String text,String key) throws Exception{
		System.out.println(text.length());
		System.out.println(key.length());
		int mod = key.length() - (text.length() % key.length());
		for(int i=0;i<mod;i++){
			text += MatrixTrans.DELIMETER;
		}
		return text;
	}
}
