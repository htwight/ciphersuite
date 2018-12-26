package ciphers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RotorTest {

    private Rotor sut;

    @Before
    public void init() {
        sut = new Rotor(new char[]{'a','b','c'});
    }

    @Test
    public void givenRotorAtPositionZero_whenTurn_thenRotorAtPositionOne() {
        sut.turn();
        Assert.assertEquals(1, sut.getPosition());
    }

    @Test
    public void givenRotor_whenTurnsAlphabetLength_thenRotorAtPositionZero() {
        for (int i = 0; i < sut.getAlphabet().length; i++)
            sut.turn();
        Assert.assertEquals(0, sut.getPosition());
    }

    @Test
    public void givenTestRotor_whenCharIndexB_thenOne() {
        Assert.assertEquals(1, sut.charIndex('B'));
    }
}
