/*
 * $Id:TestUInt16.java 32 2007-09-29 13:45:46Z gunter $
 */
package net.sourceforge.juint;

import net.sourceforge.juint.UInt16;
import junit.framework.TestCase;

public class TestUInt16 extends TestCase {
    public void testByteConstructor() {
        byte[] word = new byte[2];
        // word = -32000
        word[0] = (byte) 0x83;
        word[1] = (byte) 0x00;
        UInt16 uint16 = new UInt16(word);
        assertEquals(uint16.uint16Value(), 33536);
    }

    public void testShortConstructor() {
        UInt16 uint16 = new UInt16((short) 3000);
        assertEquals(3000, uint16.uint16Value());
    }

    public void testIntConstructor() {
        UInt16 uint16 = new UInt16(65436);
        assertEquals(65436, uint16.uint16Value());
    }

    public void testLongConstructor() {
        UInt16 uint16 = new UInt16(1000L);
        assertEquals(1000, uint16.uint16Value());
    }

    public void testIntConstructorOverflow() {
        UInt16 uint16 = new UInt16(Integer.MAX_VALUE);
        assertEquals(UInt16.MAX_VALUE, uint16.uint16Value());
    }

    public void testLongConstructorOverflow() {
        UInt16 uint16 = new UInt16(Long.MAX_VALUE);
        assertEquals(UInt16.MAX_VALUE, uint16.uint16Value());
    }

    public void testConstructorException1() {
        byte[] word = new byte[3];
        word[0] = 1;
        word[1] = 2;
        word[2] = 3;
        try {
            UInt16 uint16 = new UInt16(word);
            uint16.byteValue();
            fail("Should raise an IllegalArgumentException.");
        }
        catch (IllegalArgumentException e) {
        }
    }

    public void testConstructorException2() {
        try {
            UInt16 uint16 = new UInt16(null);
            uint16.byteValue();
            fail("Should raise an IllegalArgumentException.");
        }
        catch (IllegalArgumentException e) {
        }
    }

    public void testValueOfBigEndian() {
        byte[] word = new byte[2];
        // word = 51859
        word[0] = (byte) 0xca;
        word[1] = (byte) 0x93;
        UInt16 uint16 = UInt16.valueOfBigEndian(word);
        assertEquals(51859, uint16.uint16Value());
    }

    public void testValueOfLittleEndian() {
        byte[] word = new byte[2];
        // word = 51859
        word[0] = (byte) 0xca;
        word[1] = (byte) 0x93;
        UInt16 uint16 = UInt16.valueOfLittleEndian(word);
        assertEquals(37834, uint16.uint16Value());
    }

    public void testMaxValue() {
        UInt16 uint16 = new UInt16(65535);
        assertEquals(uint16.uint16Value(), UInt16.MAX_VALUE);
    }

    public void testShortValue() {
        UInt16 uint16 = new UInt16(1000);
        assertEquals(1000, uint16.shortValue());
    }

    public void testIntValue() {
        UInt16 uint16 = new UInt16(20000);
        assertEquals(20000, uint16.intValue());
    }

    public void testLongValue() {
        UInt16 uint16 = new UInt16(20001);
        assertEquals(20001, uint16.longValue());
    }

    public void testFloatValue() {
        UInt16 uint16 = new UInt16(20002);
        assertEquals(20002.0f, uint16.floatValue(), 0);
    }

    public void testDoubleValue() {
        UInt16 uint16 = new UInt16(1978);
        assertEquals(1978.0d, uint16.doubleValue(), 0);
    }

    public void testCompareToMore() {
        UInt16 one = new UInt16(60001);
        UInt16 two = new UInt16(60010);
        assertEquals(-9, one.compareTo(two));
    }

    public void testCompareToLess() {
        UInt16 one = new UInt16(60010);
        UInt16 two = new UInt16(60001);
        assertEquals(9, one.compareTo(two));
    }

    public void testCompareToEquals() {
        UInt16 one = new UInt16((byte) 1);
        UInt16 two = new UInt16((byte) 1);
        assertEquals(0, one.compareTo(two));
    }

    public void testEquals() {
        UInt16 one = new UInt16(65000);
        UInt16 two = new UInt16(65000);
        assertTrue(one.equals(two));
    }

    public void testEqualsNull() {
        UInt16 uint16 = new UInt16(65000);
        assertTrue(!uint16.equals(null));
    }

    public void testHashCode() {
        UInt16 uint16 = new UInt16(30);
        assertEquals(30, uint16.hashCode());
    }

    public void testToString() {
        UInt16 uint16 = new UInt16(65290);
        assertEquals("65290", uint16.toString());
    }

    public void testByteValue() {
        byte[] word = new byte[2];
        // word = 65290
        word[0] = (byte) 0xff;
        word[1] = 0x0a;
        UInt16 uint16 = new UInt16(word);
        assertEquals(10, uint16.byteValue());
    }

    public void testToBigEndian() {
        UInt16 uint16 = new UInt16(2453);
        byte[] bigEndian = uint16.toBigEndian();
        assertEquals(0x09, bigEndian[0]);
        assertEquals((byte) 0x95, bigEndian[1]);
    }

    public void testToLittleEndian() {
        UInt16 uint16 = new UInt16(2453);
        byte[] littleEndian = uint16.toLittleEndian();
        assertEquals((byte) 0x95, littleEndian[0]);
        assertEquals(0x09, littleEndian[1]);
    }

    public void testAnd() {
        UInt16 one = new UInt16(0xab);
        UInt16 two = new UInt16(0xff);
        assertEquals(new UInt16(0xab), one.and(two));
    }

    public void testNot() {
        UInt16 uint16 = new UInt16(0xab);
        assertEquals(new UInt16(0xff54), uint16.not());
    }

    public void testOr() {
        UInt16 one = new UInt16(0xab);
        UInt16 two = new UInt16(0xf0);
        assertEquals(new UInt16(0xfb), one.or(two));
    }

    public void testXor() {
        UInt16 one = new UInt16(0xab);
        UInt16 two = new UInt16(0xf0);
        assertEquals(new UInt16(0x5b), one.xor(two));
    }

    public void testAddBitmask() {
        UInt16 uint16 = new UInt16(0x02);
        assertEquals(new UInt16(0x06), uint16.addBitmask(new UInt16(0x04)));
    }

    public void testHasBitmask() {
        UInt16 uint16 = new UInt16(0x06);
        assertTrue(uint16.hasBitmask(new UInt16(0x04)));
    }

    public void testRemoveBitmask() {
        UInt16 uint16 = new UInt16(0x06);
        assertEquals(new UInt16(0x02), uint16.removeBitmask(new UInt16(0x04)));
    }
}
