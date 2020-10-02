package heartofrevel.code.crypto.ciphers;

import heartofrevel.code.crypto.ciphers.impl.AtbashCipher;

public class CipherTester {

	public static void main(String[] args) {
		String message = "HEART OF REVEL IS A DEVELOPER";
		AtbashCipher cipher = new AtbashCipher(true);
		String encrypted = cipher.encrypt(message);
		System.out.println("Cipher Text : " + encrypted);
		System.out.println("Plain Text : " + cipher.decrypt(encrypted));
	}
}