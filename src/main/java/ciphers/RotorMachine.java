package ciphers;

import java.util.ArrayList;

public class RotorMachine implements Encipherable {

    private ArrayList<Rotor> rotors;

    public RotorMachine() {
        rotors = new ArrayList<>();
    }

    public void addRotor(Rotor r) {
        rotors.add(r);
    }

    public void removeRotor(Rotor r) {
        rotors.remove(r);
    }

    @Override
    public String encipher(String plaintext) {
        StringBuilder result = new StringBuilder();
        for (char c : plaintext.toCharArray()) {
            char current = c;
            for (Rotor rotor : rotors)
                current = rotor.encipher(current);
            result.append(current);
        }
        return result.toString().toUpperCase();
    }
}
