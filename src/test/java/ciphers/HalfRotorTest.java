package ciphers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HalfRotorTest {

    private HalfRotor sut;

    @Before
    public void init() {
        char[] testInputAlphabet = {'a','b','c','d','e','f'};
        char[] testOutputAlphabet = {'b','c','d','f','a','e'};
        sut = new HalfRotor(testInputAlphabet, testOutputAlphabet);
    }

    @Test
    public void givenTestRotor_whenEncipherB_ThenC() {
        Assert.assertEquals("C", sut.encipher("B"));
    }

    @Test
    public void givenTestRotor_whenEncipherAAAAAAA_thenBCDFAEB() {
        Assert.assertEquals("BCDFAEB", sut.encipher("AAAAAAA"));
    }
}