package geco;

import java.util.Random;

public class PasswordGeneration {
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private int sizeAlphabet = 36;
    public String randomPassword(int size){
        Random r = new Random();
        int n;
        StringBuilder s = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            n = r.nextInt(sizeAlphabet+1);
            s.append(alphabet.charAt(n));
        }
        return s.toString();
    }
}
