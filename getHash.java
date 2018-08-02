import java.util.*;
import java.io.*;

import java.security.MessageDigest;
import java.nio.file.Files;

public class getHash {

    /**
     * Calulates the hash value
     * @param inputBytes Bytes from input file
     * @param algorithm Algorithm to be used
     */
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

    /**
     * Main method
     */
    public static void main(String[] args) {
        // Open a scanner
        Scanner s = new Scanner(System.in);

        // Prompt the user for algorithm type and file location
        System.out.println("\nChoose from MD2, MD5, SHA-1, SHA-224, SHA-256, " +
            "SHA-384, SHA-512.\n");
        System.out.print("Algorithm: ");
        String algorithm = s.nextLine();
        System.out.print("Input file: ");
        String inputFile = s.nextLine();

        // Try to open the input file
        try {
            // Try to get byte array from input file
            File file = new File(inputFile);
            byte[] fileBytes = Files.readAllBytes(file.toPath());
            s.close();

            // Final printout
            String fileHash = hash(fileBytes, algorithm);

            // Ensure hash() returned something
            if (fileHash != null) {
                System.out.println("\nHash: " + fileHash + "\n");
            } else {
                System.out.println("\nError: Hash algorithm does not exist!\n");
            }
        }
        catch(Exception e){
            System.out.println("\nError: Input file does not exist!\n");
            s.close();

            // Exit
            System.exit(1);
        }

        
    }
}
