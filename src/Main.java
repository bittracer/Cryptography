import java.util.Scanner;

public class Main {

	private static Scanner scanner;

	/**
	 * @param ar
	 */
	public static void main(String ar[]) {

		scanner = new Scanner(System.in);
		int number = 0;
		String text = "";
		int intkey = 0;
		String stringkey = "";
		String pq = "";
		int what = 0;
		String[] yesNo = { "Yes", "No" };
		String[] algo = { "Caesar cipher", "Vigenere cipher", "Matrix ransposition cipher", "RSA" };
		String[] method = { "Encryption", "Decryption" };
		System.out.println("Select the encryption Algorithm(By Number):");

		try {
			for (int i = 0; i < algo.length; i++) {
				System.out.println("  " + (i + 1) + ". " + algo[i]);
			}
			number = scanner.nextInt();
			scanner.nextLine();

			switch (number) {

			case 1: // Caesar Cipher
				System.out.println("Please select Encryption or Decryption(By Number):");
				for (int i = 0; i < method.length; i++) {
					System.out.println("    " + (i + 1) + ". " + method[i]);
				}
				what = scanner.nextInt();

				switch (what) {

				case 1:// Caesar Cipher Encryption
					System.out.println("Enter the plain text for encryption:");
					scanner.nextLine();
					text = scanner.nextLine();

					System.out.println("Enter the Key for encryption:");
					intkey = scanner.nextInt();
					System.out.println("\nInput plain text: " + text);
					System.out.println("Input key: " + intkey);
					String cipher = CaesarCipher.Encrypt(text, intkey);

					System.out.println("\nWant to decrypt the above text again ? (By number)");
					for (int j = 0; j < yesNo.length; j++) {
						System.out.println("    " + (j + 1) + " ." + yesNo[j]);
					}
					if (CaesarCipher.scanner.nextInt() == 1) {
						CaesarCipher.Decrypt(cipher, intkey);
					} else {
						System.exit(0);
					}
					break;
				case 2: // Caesar Cipher Decryption
					System.out.println("Enter the cipher text for decryption:");
					scanner.nextLine();
					text = scanner.nextLine();

					System.out.println("Enter the Key for decryption:");
					intkey = scanner.nextInt();
					System.out.println("\nInput cipher text: " + text);
					System.out.println("Input key: " + intkey);
					CaesarCipher.Decrypt(text, intkey);
					break;
				}
				break;
			case 2:// Vigenere Cipher
				System.out.println("Please select Encryption or Decryption(By Number):");
				for (int i = 0; i < method.length; i++) {
					System.out.println("    " + (i + 1) + ". " + method[i]);
				}
				what = scanner.nextInt();

				switch (what) {

				case 1:// Vigenere Cipher Encryption
					System.out.println("Enter the plain text for encryption:");
					scanner.nextLine();
					text = scanner.nextLine();

					System.out.println("Enter the Key for encryption:");
					stringkey = scanner.nextLine();
					System.out.println("\nInput plain text: " + text);
					System.out.println("Input key: " + stringkey);
					String cipher = Vigenere.Encrypt(text, stringkey);

					System.out.println("\nWant to decrypt the above text again ? (By number)");
					for (int j = 0; j < yesNo.length; j++) {
						System.out.println("    " + (j + 1) + " ." + yesNo[j]);
					}
					if (CaesarCipher.scanner.nextInt() == 1) {
						Vigenere.Decrypt(cipher, stringkey);
					} else {
						System.exit(0);
					}
					break;
				case 2:// Vigenere Cipher Decryption
					System.out.println("Enter the cipher text for decryption:");
					scanner.nextLine();
					text = scanner.nextLine();

					System.out.println("Enter the Key for decryption:");
					stringkey = scanner.nextLine();
					System.out.println("\nInput cipher text: " + text);
					System.out.println("Input key: " + stringkey);
					Vigenere.Decrypt(text, stringkey);
					break;
				}
				break;
			case 3:// Matrix transposition cipher
				System.out.println("Please select Encryption or Decryption(By Number):");
				for (int i = 0; i < method.length; i++) {
					System.out.println("    " + (i + 1) + ". " + method[i]);
				}
				what = scanner.nextInt();
				switch (what) {

				case 1:// Matrix transposition cipher Encryption
					System.out.println("Enter the plain text for encryption:");
					scanner.nextLine();
					text = scanner.nextLine();

					System.out.println("Enter the Key for encryption:");
					stringkey = scanner.nextLine();
					System.out.println("\nInput plain text: " + text);
					System.out.println("Input key: " + stringkey);
					String cipher = MatrixTrans.Encrypt(text, stringkey);

					System.out.println("\nWant to decrypt the above text again ? (By number)");
					for (int j = 0; j < yesNo.length; j++) {
						System.out.println("    " + (j + 1) + ". " + yesNo[j]);
					}
					if (CaesarCipher.scanner.nextInt() == 1) {
						MatrixTrans.Decrypt(cipher, stringkey);
					} else {
						System.exit(0);
					}
					break;
				case 2:// Matrix transposition cipher Decryption
					System.out.println("Enter the cipher text for decryption:");
					scanner.nextLine();
					text = scanner.nextLine();

					System.out.println("Enter the Key for decryption:");
					stringkey = scanner.nextLine();
					System.out.println("\nInput cipher text: " + text);
					System.out.println("Input key: " + stringkey);
					MatrixTrans.Decrypt(text, stringkey);
					break;
				}
				break;
			case 4:// RSA
				System.out.println("Enter 2 different prime numbers p & q (Comma seperated):");
				pq = scanner.nextLine();
				RSA.Encrypt(pq);
				break;
			}
		} catch (Exception e) {
			System.out.println("Invalid Input. Please Try again!");
			System.exit(-1);
		}

	}
}
