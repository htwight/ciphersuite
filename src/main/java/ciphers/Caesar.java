package ciphers;

public class Caesar implements Encipherable, Decipherable {

    private char[] alphabet;
    private char key;

    public Caesar(char[] alphabet, char key) {
        this.alphabet = alphabet;
        this.key = key;
    }

    private char decipher(char c) {
        int index = Math.floorMod(symbolIndex(c) - symbolIndex(key), alphabet.length);
        return alphabet[index];
    }

    @Override
    public String decipher(String ciphertext) {
        StringBuilder result = new StringBuilder();
        for (char c : ciphertext.toCharArray())
            result.append(decipher(c));

        return result.toString().toUpperCase();
    }

    private char encipher(char c) {
        int index = (symbolIndex(c) + symbolIndex(key)) % alphabet.length;
        return alphabet[index];
    }

    @Override
    public String encipher(String plaintext) {
        StringBuilder result = new StringBuilder();
        for (char c : plaintext.toCharArray())
            result.append(encipher(c));

        return result.toString().toUpperCase();
    }

    private int symbolIndex(char symbol) {
        for (int i = 0; i < alphabet.length; i++)
            if (Character.toUpperCase(alphabet[i]) == Character.toUpperCase(symbol))
                return i;
        return -1;
    }
}