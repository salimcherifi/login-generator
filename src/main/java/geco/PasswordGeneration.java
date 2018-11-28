package geco;

import java.util.Random;

/**
 * The type Password generation.
 */
public class PasswordGeneration {
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private int sizeAlphabet = 36;

    /**
     * Generate a random password of size size.
     *
     * @param size the size
     * @return the string
     */
    public String randomPassword(int size) {
        Random r = new Random();
        int n;
        StringBuilder s = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            n = r.nextInt(sizeAlphabet);
            s.append(alphabet.charAt(n));
        }
        return s.toString();
    }
}
