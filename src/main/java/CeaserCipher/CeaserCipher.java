import java.util.Scanner;

public class CeaserCipher {
    // This rotates a character k-positions
    public static char cipher(char c, int k) {
        //Here we declare some helping constants
        final int alphaLength = 26;
        final char asciiShift = Character.isUpperCase(c) ? 'A' : 'a';
        final int cipherShift = k % alphaLength;

        // Here
        // we shift down to 0..25 for a..z
        char shifted = (char) (c - asciiShift);

        // Here we rotate the letter and handle "wrap-around" for negatives and value >= 26
        shifted = (char) ((shifted + cipherShift + alphaLength) % alphaLength);

        // Here we shift back up to english characters
        return (char) (shifted + asciiShift);
    }

    // Here we Rotate a string k-positions
    public static String cipher(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(cipher(s.charAt(i), k));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String password;
        int key;

        System.out.print("Please enter the password: ");
        password = keyboard.nextLine();

        do {
            System.out.print("Please enter a key between 1 to 25: ");
            key = keyboard.nextInt();

            //here we handle key errors
            if (key < 1 || key > 25) {
                System.out.printf(" The key must be between 1 and 25, you entered %d.\n", key);
            }
        } while (key < 1 || key > 25);


        System.out.println("Password:\t" + password);
        String encryption = cipher(password, key);
        System.out.println("Encrypted:\t" + encryption);
        System.out.println("Decrypted:\t" + cipher(encryption, -key));

    }
}