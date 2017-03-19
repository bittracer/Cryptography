import java.util.Scanner;

public class RSA {

	public static Long n = 0l;
	public static Long totient = 0l;
	public static Long e = 0l;
	public static Long d = 0l;
	private static Scanner scanner;
	static String message = "";

	/**
	 * @param pq
	 */
	//Function call for Encryption
	public static void Encrypt(String pq) throws Exception{

		scanner = new Scanner(System.in);

		Long p = Long.parseLong(pq.split(",")[0]);
		Long q = Long.parseLong(pq.split(",")[1]);

		// calculate n=p*q
		n = p * q;

		totient = (p - 1) * (q - 1);

		System.out.println("Enter the message: ");
		message = scanner.nextLine();

		for (Long i = 2l;; i++) {
			if (RSA.calculateRelativePrime(i, totient)) {
				e = i;
				break;
			}
		}

		for (int i = 1;; i++) {
			Long modulo = ((i * totient) + 1) % totient;
			Long remainder = ((i * totient) + 1) % e;
			if ((modulo == 1) && (remainder == 0)) {
				d = ((i * totient) + 1) / e;
				break;
			}
		}

		System.out.println("\nInput Prime numbers P = " + pq.split(",")[0] + " , q = " + pq.split(",")[1]);
		System.out.println("Input Message: " + message);
		System.out.println("Generated Public Key (e,n)  : (" + e + "," + n + ")");
		System.out.println("Generated : " + Math.pow(Integer.parseInt(message), e) % n);
	}

	/**
	 * @param num1
	 * @param totient
	 * @return
	 */
	// Calculated Relative prime (Basically a GCD)
	public static boolean calculateRelativePrime(Long num1, Long totient) throws Exception{

		Long temp;
		while (totient != 0) {
			temp = num1;
			num1 = totient;
			totient = temp % totient;
		}
		return num1 == 1;
	}
}
