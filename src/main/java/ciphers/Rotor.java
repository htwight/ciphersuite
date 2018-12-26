package ciphers;

public class Rotor {

    private int position;
    private char[] alphabet;

    public Rotor(char[] alphabet) {
        this.position = 0;
        this.alphabet = alphabet;
    }

    public int getPosition() {
        return this.position;
    }

    public void resetPosition() {
        this.position = 0;
    }

    public char[] getAlphabet() {
        return this.alphabet;
    }

    public void turn() {
        this.position++;
        if (position == alphabet.length)
            position = 0;
    }

    public int charIndex(char c) {
        for (int i = 0; i < alphabet.length; i++)
            if (Character.toUpperCase(alphabet[i]) == Character.toUpperCase(c))
                return i;
        return -1;
    }
}