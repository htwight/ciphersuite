package control;

import ciphers.Decipherable;
import ciphers.Encipherable;

import java.util.ArrayList;
import java.util.List;

public class CipherComposition implements Encipherable {

    private List<Encipherable> ciphers;

    public CipherComposition() {
        ciphers = new ArrayList<>();
    }

    public void addCipher(Encipherable e) {
        ciphers.add(e);
    }


    @Override
    public String encipher(String plaintext) {
        String result = plaintext;
        for (Encipherable e : ciphers)
            result = e.encipher(result);

        return result;
    }

    public String decipher(String ciphertext) throws NotDecipherableException {
        String result = ciphertext;
        for (int i = ciphers.size() - 1; i >= 0; i--)
            if (!(ciphers.get(i) instanceof Decipherable))
                throw new NotDecipherableException("Can not be deciphered");
            else
                result = ((Decipherable) ciphers.get(i)).decipher(result);
        return result;
    }
}
