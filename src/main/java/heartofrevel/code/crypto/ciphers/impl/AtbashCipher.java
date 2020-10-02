package heartofrevel.code.crypto.ciphers.impl;

import java.util.HashMap;
import java.util.Map;

import heartofrevel.code.crypto.ciphers.api.Cipher;

public class AtbashCipher implements Cipher{
	private Map<Character, Character> key;
	private boolean preserveSpaces;
	
	public AtbashCipher(boolean preserveSpaces) {
		key = new HashMap<>();
		key.put('A', 'Z');
		key.put('B', 'Y');
		key.put('C', 'X');
		key.put('D', 'W');
		key.put('E', 'V');
		key.put('F', 'U');
		key.put('G', 'T');
		key.put('H', 'S');
		key.put('I', 'R');
		key.put('J', 'Q');
		key.put('K', 'P');
		key.put('L', 'O');
		key.put('M', 'N');
		key.put('N', 'M');
		key.put('O', 'L');
		key.put('P', 'K');
		key.put('Q', 'J');
		key.put('R', 'I');
		key.put('S', 'H');
		key.put('T', 'G');
		key.put('U', 'F');
		key.put('V', 'E');
		key.put('W', 'D');
		key.put('X', 'C');
		key.put('Y', 'B');
		key.put('Z', 'A');
		this.preserveSpaces =  preserveSpaces;
	}
	
	public AtbashCipher() {
		this(false);
	}
	

	public String encrypt(String plainText) {
		if(!preserveSpaces) {
			plainText = plainText.replace(" ", "");
		}
		char[] cipherText = new char[plainText.length()];
		for (int i=0; i < plainText.length(); i++) {
			if(plainText.charAt(i) == ' ') {
				cipherText[i] = ' ';
				continue;
			}
			cipherText[i] = key.get(plainText.charAt(i));
		}
		return new String(cipherText);
	}
	
	public String decrypt(String cipherText) {
		if(!preserveSpaces) {
			cipherText = cipherText.replace(" ", "");
		}
		char[] plainText = new char[cipherText.length()];
		for (int i=0; i < cipherText.length(); i++) {
			if(cipherText.charAt(i) == ' ') {
				plainText[i] = ' ';
				continue;
			}
			plainText[i] = key.get(cipherText.charAt(i));
		}
		return new String(plainText);
	}	
}
