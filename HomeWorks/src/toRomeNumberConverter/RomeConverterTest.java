package toRomeNumberConverter;

import static org.junit.Assert.*;

import java.awt.image.ConvolveOp;

import org.junit.Test;

public class RomeConverterTest {

    @Test
    public void initRomeConverter() {
        RomeConverter x = new RomeConverter(0);
        assertEquals(Integer.valueOf(0), x.parseArab.get(1000));
        assertEquals(Integer.valueOf(0), x.parseArab.get(500));
        assertEquals(Integer.valueOf(0), x.parseArab.get(100));
        assertEquals(Integer.valueOf(0), x.parseArab.get(50));
        assertEquals(Integer.valueOf(0), x.parseArab.get(10));
        assertEquals(Integer.valueOf(0), x.parseArab.get(5));
        assertEquals(Integer.valueOf(0), x.parseArab.get(1));

        RomeConverter x1 = new RomeConverter(1699);
        assertEquals(Integer.valueOf(1), x1.parseArab.get(1000));
        assertEquals(Integer.valueOf(1), x1.parseArab.get(500));
        assertEquals(Integer.valueOf(1), x1.parseArab.get(100));
        assertEquals(Integer.valueOf(1), x1.parseArab.get(50));
        assertEquals(Integer.valueOf(4), x1.parseArab.get(10));
        assertEquals(Integer.valueOf(1), x1.parseArab.get(5));
        assertEquals(Integer.valueOf(4), x1.parseArab.get(1));

        try {
            RomeConverter x2 = new RomeConverter(-125);
            fail("Year must by => zero");
        } catch (IllegalArgumentException iae) {
            // TODO: handle exception
        }

    }

    @Test
    public void testConvertM() {
        RomeConverter x = new RomeConverter(3000);
        assertEquals("MMM", x.convertM());
    }

    @Test
    public void testConvertD() {
        RomeConverter x1 = new RomeConverter(500);
        assertEquals("D", x1.convertD());
        RomeConverter x2 = new RomeConverter(900);
        assertEquals("CM", x2.convertD());
    }

    @Test
    public void testConvertC() {
        RomeConverter x1 = new RomeConverter(300);
        assertEquals("CCC", x1.convertC());
        RomeConverter x2 = new RomeConverter(900);
        assertEquals("", x2.convertC());
    }

    @Test
    public void testConvertL() {
        RomeConverter x1 = new RomeConverter(50);
        assertEquals("L", x1.convertL());
        RomeConverter x2 = new RomeConverter(90);
        assertEquals("XC", x2.convertL());
    }

    @Test
    public void testConvertX() {
        RomeConverter x1 = new RomeConverter(40);
        assertEquals("XXXX", x1.convertX());
        RomeConverter x2 = new RomeConverter(90);
        assertEquals("", x2.convertX());
    }

    @Test
    public void testConvertV() {
        RomeConverter x1 = new RomeConverter(5);
        assertEquals("V", x1.convertV());
        RomeConverter x2 = new RomeConverter(9);
        assertEquals("IX", x2.convertV());
    }

    @Test
    public void testConvertI() {
        RomeConverter x1 = new RomeConverter(3);
        assertEquals("III", x1.convertI());
        RomeConverter x2 = new RomeConverter(9);
        assertEquals("", x2.convertI());
        RomeConverter x3 = new RomeConverter(4);
        assertEquals("IV", x3.convertI());
    }

    @Test
    public void testConvert() {
        String temp = RomeConverter.convertNumber(1699);
        assertEquals("MDCXCIX", temp);
        try {
            RomeConverter.convertNumber(-126);
            fail("Year must by => zero");
        } catch (IllegalArgumentException iae) {
            // TODO: handle exception
        }
    }

}
