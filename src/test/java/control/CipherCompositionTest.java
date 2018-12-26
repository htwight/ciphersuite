package control;

import ciphers.Caesar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CipherCompositionTest {

    private CipherComposition sut;
    private Caesar caesarOne;
    private Caesar caesarTwo;

    @Before
    public void init() {
        caesarOne = new Caesar(new char[]{'a','b','c','d','e','f'}, 'b');
        caesarTwo = new Caesar(new char[]{'a','b','c','d','e','f'}, 'd');
        sut = new CipherComposition();
        sut.addCipher(caesarOne);
        sut.addCipher(caesarTwo);
    }

    @Test
    public void givenSut_whenEncipherABC_ThenEFA() {
        Assert.assertEquals("EFA", sut.encipher("ABC"));
    }

    @Test
    public void givenSut_whenDecipherEFA_thenABC() {
        try {
            Assert.assertEquals("ABC", sut.decipher("EFA"));
        } catch (NotDecipherableException e) {
            e.printStackTrace();
        }
    }
}
