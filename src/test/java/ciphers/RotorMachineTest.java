package ciphers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class RotorMachineTest {

    private RotorMachine sut;

    @Mock
    private HalfRotor testHalfRotor;

    @Mock
    private FullRotor testFullRotor;

    @Before
    public void init() {
        sut = new RotorMachine();

        testFullRotor = mock(FullRotor.class);
        testHalfRotor = mock(HalfRotor.class);

        sut.addRotor(testFullRotor);
        sut.addRotor(testHalfRotor);
    }

    @Test
    public void givenTestRotorMachine_whenEncipherAA_thenBB() {
        when(testFullRotor.encipher('A')).thenReturn('B');
        when(testHalfRotor.encipher('B')).thenReturn('C');

        Assert.assertEquals("CC", sut.encipher("AA"));

        verify(testHalfRotor, times(2)).encipher('B');
        verify(testFullRotor, times(2)).encipher('A');
    }
}
