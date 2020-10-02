package heartofrevel.code.crypto.ciphers.api;

public interface Cipher {
	public String encrypt(String plainText);
	public String decrypt(String cipherText);
}
