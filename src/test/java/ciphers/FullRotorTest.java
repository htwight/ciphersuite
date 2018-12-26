package ciphers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FullRotorTest {

    private FullRotor sut;

    @Before
    public void init() {
        int[] testWiring = {5,4,3,2,1,0};
        char[] testAlphabet = {'a','b','c','d','e','f'};
        sut = new FullRotor(testAlphabet, testWiring);
    }

    @Test
    public void givenTestRotor_whenEncipherA_thenF() {
        Assert.assertEquals("F", sut.encipher("A"));
    }

    @Test
    public void givenTestRotor_whenEncipherB_thenE() {
        Assert.assertEquals("E", sut.encipher("B"));
    }

    @Test
    public void givenTestRotor_whenEnicipherAA_thenFE() {
        Assert.assertEquals("FE", sut.encipher("AA"));
    }

    @Test
    public void givenTestRotor_whenEncipherAAAAAAAA_thenFEDCBAF() {
        Assert.assertEquals("FEDCBAF", sut.encipher("AAAAAAA"));
    }

    @Test
    public void givenMixedWiring_whenDecipherACD_thenAAA() {
        sut = new FullRotor(new char[]{'a','b','c'}, new int[]{0,2,1});
        Assert.assertEquals("AAA", sut.decipher("ACB"));
    }
}
