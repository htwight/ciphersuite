package ciphers;

public class HalfRotor extends Rotor implements Encipherable {

    private char[] outputAlphabet;

    public HalfRotor(char[] inputAlphabet, char[] outputAlphabet) {
        super(inputAlphabet);
        this.outputAlphabet = outputAlphabet;
    }

    @Override
    protected char encipher(char plaintext) {
        int inIndex = charIndex(plaintext);
        int outIndex = Math.floorMod(inIndex + getPosition(), getAlphabet().length);
        return outputAlphabet[outIndex];
    }

    @Override
    public String encipher(String plaintext) {
        StringBuilder result = new StringBuilder();
        for (char c : plaintext.toCharArray()) {
            result.append(encipher(c));
            turn();
        }
        resetPosition();
        return result.toString().toUpperCase();
    }
}