public class Vigenere {

	/**
	 * @param text
	 * @param key
	 * @return
	 */
	// Function call for Encryption
	public static String Encrypt(String text, String key) throws Exception

	{

		String finalKey = Vigenere.formatKey(key, text.length());
		String cipher = "";

		for (int i = 0; i < text.length(); i++)

		{
			char c = text.charAt(i);
			char shift = Character.isUpperCase(c) ? 'A' : 'a';
			cipher += (char) ((c + finalKey.charAt(i) - 2 * shift) % 26 + shift);
		}

		System.out.println("Encryption (Plain Text to Cipher Text): " + cipher);
		return cipher;

	}

	/**
	 * @param text
	 * @param key
	 * @return
	 */
	// Function call for Decryption
	public static String Decrypt(String text, final String key) throws Exception

	{

		String finalKey = Vigenere.formatKey(key, text.length());
		String plaintext = "";

		for (int i = 0; i < text.length(); i++)

		{
			char c = text.charAt(i);
			char shift = Character.isUpperCase(c) ? 'A' : 'a';
			plaintext += (char) ((c - finalKey.charAt(i) + 26) % 26 + shift);
		}
		System.out.println("Decryption (Cipher Text to Plain Text): " + plaintext);
		return plaintext;
	}

	/**
	 * @param key
	 * @param lengthOfPlainText
	 * @return
	 */
	// Append Extra % to fill in the matrix at the end
	public static String formatKey(String key, int lengthOfPlainText) throws Exception {

		int keyLength = key.length();
		String finalKey = key;
		int i = 0;
		while (finalKey.length() != lengthOfPlainText) {
			if (i < keyLength) {
				finalKey += key.charAt(i);
				i++;
			} else {
				i = 0;
			}
		}
		return finalKey;
	}
}
