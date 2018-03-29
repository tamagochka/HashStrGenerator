package my.tamagochka.hash;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashStrGenerator {

    public static String hash(String msg, String hash_type) throws NoSuchAlgorithmException {

        MessageDigest hasher = MessageDigest.getInstance(hash_type);
        try {
            hasher.update(msg.getBytes("UTF-8"), 0, msg.length());
        } catch(UnsupportedEncodingException e) { }
        return DatatypeConverter.printHexBinary(hasher.digest());
    }

    public static void main(String[] args) {
        if(args.length  == 0) {
            System.out.println("Need string to hash!");
            return;
        }
        try {
            System.out.println("MD5: " + hash(args[0], "MD5"));
            System.out.println("SHA-1: " + hash(args[0], "SHA-1"));
            System.out.println("SHA-256: " + hash(args[0], "SHA-256"));
            System.out.println("SHA-384: " + hash(args[0], "SHA-384"));
            System.out.println("SHA-512: " + hash(args[0], "SHA-512"));
        } catch(NoSuchAlgorithmException e) { }
    }
}
