package heartofrevel.code.crypto.ciphers.impl;

import java.util.Map;
import java.util.stream.Collectors;

import heartofrevel.code.crypto.ciphers.api.Cipher;

public class SubstitutionCipher implements Cipher{
	
	private Map<Character, Character> key;
	private Map<Character, Character> keyInversed;
	private boolean preserveSpaces;
	
	public SubstitutionCipher(Map<Character, Character> key) {
		this(key, false);
	}
	
	public SubstitutionCipher(Map<Character, Character> key, boolean preserveSpaces) {
		this.key = key;
		this.preserveSpaces = preserveSpaces;
		this.keyInversed = key.entrySet()
			       .stream()
			       .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
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
			plainText[i] = keyInversed.get(cipherText.charAt(i));
		}
		return new String(plainText);
	}
}
