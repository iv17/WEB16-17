package BSEP.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class HashAndSalt {

	//==============================HASH AND SALT==============================

	public static byte[] generateSalt() {
		//Always use a SecureRandom generator
		try {
			SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
			byte[] salt = new byte[16];
			sr.nextBytes(salt);
			return salt;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static byte[] hashPassword(String password, byte[] salt) {
		try {
			int iterations = 1000;
			char[] chars = password.toCharArray();

			PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

			byte[] hash = skf.generateSecret(spec).getEncoded();
			return hash;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return null;
	}


	public static boolean authenticate(String attemptedPassword, byte[] storedPassword, byte[] salt) {
		try {
			int iterations = 1000;

			PBEKeySpec spec = new PBEKeySpec(attemptedPassword.toCharArray(), salt, iterations, storedPassword.length * 8);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] testHash = skf.generateSecret(spec).getEncoded();

			int diff = storedPassword.length ^ testHash.length;
			for(int i = 0; i < storedPassword.length && i < testHash.length; i++)
			{
				diff |= storedPassword[i] ^ testHash[i];
			}
			return diff == 0;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean checkIntegrity(String data, byte[] dataHash) {
		byte[] newDataHash = hash(data);
		return Arrays.equals(dataHash, newDataHash);
	}

	public static byte[] hash(String data) {
		//Kao hes funkcija koristi SHA-256
		try {
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
			byte[] dataHash = sha256.digest(data.getBytes());
			return dataHash;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
