package heartofrevel.code.crypto.ciphers.impl;

import heartofrevel.code.crypto.ciphers.api.Cipher;

public class CaesarCipher implements Cipher{
	
	private int key;
	private boolean preserveSpaces;
	
	public CaesarCipher(int key) {
		this(key, false);
	}
	
	public CaesarCipher(int key, boolean preserveSpaces) {
		this.key = key;
		this.preserveSpaces = preserveSpaces;
	}
	
	public String encrypt(String plainText) {
		if(!preserveSpaces) {
			plainText = plainText.replace(" ", "");
		}
		char[] cipherText = new char[plainText.length()];
		plainText = plainText.toUpperCase();
		for (int i=0; i < plainText.length(); i++) {
			if(plainText.charAt(i) == ' ') {
				cipherText[i] = ' ';
				continue;
			}
			cipherText[i] = (char) (Math.floorMod(((int)plainText.charAt(i) + key - 65), 26) + 65);
		}
		return new String(cipherText);
	}
	
	public String decrypt(String cipherText) {
		if(!preserveSpaces) {
			cipherText = cipherText.replace(" ", "");
		}
		char[] plainText = new char[cipherText.length()];
		cipherText = cipherText.toUpperCase();
		for (int i=0; i < cipherText.length(); i++) {
			if(cipherText.charAt(i) == ' ') {
				plainText[i] = ' ';
				continue;
			}
			plainText[i] = (char) (Math.floorMod(((int)cipherText.charAt(i) - key - 65), 26) + 65);
		}
		return new String(plainText);
	}	
}
