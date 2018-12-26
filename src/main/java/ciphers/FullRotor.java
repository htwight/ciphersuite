package ciphers;

public class FullRotor extends Rotor implements Encipherable, Decipherable {

    private int[] wiring;

    public FullRotor(char[] alphabet, int[] wiring) {
        super(alphabet);
        this.wiring = wiring;
    }

    @Override
    public String decipher(String ciphertext) {
        return encipher(ciphertext); //Inverse operation
    }

    private char encipher(char plaintext) {
        int inPosition = charIndex(plaintext);
        int outPosition = Math.floorMod(wiring[inPosition] - getPosition(), getAlphabet().length);
        return getAlphabet()[outPosition];
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