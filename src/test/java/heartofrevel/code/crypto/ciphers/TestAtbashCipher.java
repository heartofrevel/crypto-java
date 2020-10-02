package heartofrevel.code.crypto.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import heartofrevel.code.crypto.ciphers.impl.AtbashCipher;

class TestAtbashCipher {

	@Test
	void testAtbashCipherEncryptionNominal() {
		String message = "HEART OF REVEL IS A DEVELOPER";
		String expectedOutput = "SVZIG LU IVEVO RH Z WVEVOLKVI";
		AtbashCipher cipher = new AtbashCipher(true);
		String cipherText = cipher.encrypt(message);
		assertEquals(expectedOutput, cipherText);
	}
	
	@Test
	void testAtbashCipherDecryptionNominal() {
		String cipherText = "SVZIG LU IVEVO RH Z WVEVOLKVI";
		String expectedOutput = "HEART OF REVEL IS A DEVELOPER";
		AtbashCipher cipher = new AtbashCipher(true);
		String plainText = cipher.decrypt(cipherText);
		assertEquals(expectedOutput, plainText);
	}
}
