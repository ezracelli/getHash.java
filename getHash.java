import java.util.*;
import java.io.*;

import java.security.MessageDigest;
import java.nio.file.Files;

public class getHash {

    public static String hash(byte[] inputBytes, String algorithm){
        String hashValue = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(inputBytes);
            byte[] digestedBytes = messageDigest.digest();
            hashValue = DatatypeConverterImplMod.printHexBinary(digestedBytes).toLowerCase();
        }
        catch(Exception e){

        }

        return hashValue;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("\nChoose from MD2, MD5, SHA-1, SHA-224, SHA-256, " +
            "SHA-384, SHA-512.\n");
        System.out.print("Algorithm: ");
        String algorithm = s.nextLine();
        System.out.print("Input file: ");
        String inputFile = s.nextLine();

        try {
            File file = new File(inputFile);
            byte[] fileBytes = Files.readAllBytes(file.toPath());
            System.out.println("\nHash: " + hash(fileBytes, algorithm));
        }
        catch(Exception e){

        }
    }
}
