package ciphers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CaesarTest {

    private Caesar sut;
    private char[] testAlphabet;
    private char testKey;

    @Before
    public void init() {
        testAlphabet = new char[]{'a','b','c','d','e','f'};
        testKey = 'c';
        sut = new Caesar(testAlphabet, testKey);
    }

    @Test
    public void givenTestCaesar_whenEncipherABC_thenCDE() {
        Assert.assertEquals("CDE", sut.encipher("ABC"));
    }

    @Test
    public void givenTestCaesar_whenDecipherCDE_thenABC() {
        Assert.assertEquals("ABC", sut.decipher("CDE"));
    }
}