/*
 * $Id:TestUInt32.java 32 2007-09-29 13:45:46Z gunter $
 */
package net.sourceforge.juint;

import net.sourceforge.juint.UInt32;
import junit.framework.TestCase;

public class TestUInt32 extends TestCase {
    public void testByteConstructor() {
        byte[] doubleWord = new byte[4];
        // doubleWord = 2197817884
        doubleWord[0] = (byte) 0x83;
        doubleWord[1] = (byte) 0x00;
        doubleWord[2] = (byte) 0x0a;
        doubleWord[3] = (byte) 0x1c;
        UInt32 uint32 = new UInt32(doubleWord);
        assertEquals(2197817884L, uint32.uint32Value());
    }

    public void testShortConstructor() {
        UInt32 uint32 = new UInt32((short) 130);
        assertEquals(130, uint32.uint32Value());
    }

    public void testIntConstructor() {
        UInt32 uint32 = new UInt32(-100);
        assertEquals(4294967196L, uint32.uint32Value());
    }

    public void testLongConstructor() {
        UInt32 uint32 = new UInt32(100L);
        assertEquals(100, uint32.uint32Value());
    }

    public void testLongConstructorOverflow() {
        UInt32 uint32 = new UInt32(Long.MAX_VALUE);
        assertEquals(UInt32.MAX_VALUE, uint32.uint32Value());
    }

    public void testConstructorException() {
        byte[] doubleWord = new byte[3];
        doubleWord[0] = 1;
        doubleWord[1] = 2;
        doubleWord[2] = 3;
        try {
            UInt32 uint32 = new UInt32(doubleWord);
            uint32.byteValue();
            fail("Should raise an IllegalArgumentException.");
        }
        catch (IllegalArgumentException e) {
        }
    }

    public void testConstructorNullDoubleWord() {
        try {
            new UInt32(null);
            fail("Should raise an IllegalArgumentException.");
        }
        catch (IllegalArgumentException e) {
        }
    }

    public void testValueOfBigEndian() {
        byte[] doubleWord = new byte[4];
        doubleWord[0] = (byte) 0xca;
        doubleWord[1] = (byte) 0x93;
        doubleWord[2] = 0x10;
        doubleWord[3] = 0x11;
        UInt32 uint32 = UInt32.valueOfBigEndian(doubleWord);
        assertEquals(3398635537L, uint32.uint32Value());
    }

    public void testValueOfLittleEndian() {
        byte[] doubleWord = new byte[4];
        doubleWord[0] = (byte) 0xca;
        doubleWord[1] = (byte) 0x93;
        doubleWord[2] = 0x10;
        doubleWord[3] = 0x11;
        UInt32 uint32 = UInt32.valueOfLittleEndian(doubleWord);
        assertEquals(286299082L, uint32.uint32Value());
    }

    public void testMaxValue() {
        UInt32 uint32 = new UInt32(4294967295L);
        assertEquals(UInt32.MAX_VALUE, uint32.uint32Value());
    }

    public void testShortValue() {
        UInt32 uint32 = new UInt32(1000);
        assertEquals(1000, uint32.shortValue());
    }

    public void testIntValue() {
        UInt32 uint32 = new UInt32(20000);
        assertEquals(20000, uint32.intValue());
    }

    public void testLongValue() {
        UInt32 uint32 = new UInt32(20001);
        assertEquals(20001, uint32.longValue());
    }

    public void testFloatValue() {
        UInt32 uint32 = new UInt32(20002);
        assertEquals(20002.0f, uint32.floatValue(), 0);
    }

    public void testDoubleValue() {
        UInt32 uint32 = new UInt32(1978);
        assertEquals(1978.0d, uint32.doubleValue(), 0);
    }

    public void testCompareToMore() {
        UInt32 one = new UInt32(1);
        UInt32 two = new UInt32(10);
        assertEquals(-9, one.compareTo(two));
    }

    public void testCompareToLess() {
        UInt32 one = new UInt32(10);
        UInt32 two = new UInt32(1);
        assertEquals(9, one.compareTo(two));
    }

    public void testCompareToEquals() {
        UInt32 one = new UInt32((byte) 1);
        UInt32 two = new UInt32((byte) 1);
        assertEquals(0, one.compareTo(two));
    }

    public void testHashCode() {
        UInt32 uint32 = new UInt32((byte) 10);
        assertEquals(uint32.intValue(), uint32.hashCode());
    }

    public void testEquals() {
        UInt32 one = new UInt32(1);
        UInt32 two = new UInt32(1);
        assertTrue(one.equals(two));
    }

    public void testToString() {
        UInt32 uint32 = new UInt32(65290);
        assertEquals("65290", uint32.toString());
    }

    public void testByteValue() {
        byte[] doubleWord = new byte[4];
        // doubleWord = 4278897153
        doubleWord[0] = (byte) 0xff;
        doubleWord[1] = 0x0a;
        doubleWord[2] = (byte) 0xca;
        doubleWord[3] = 0x01;
        UInt32 uint32 = new UInt32(doubleWord);
        assertEquals(1, uint32.byteValue());
    }

    public void testToBigEndian() {
        UInt32 uint32 = new UInt32(2453);
        byte[] bigEndian = uint32.toBigEndian();
        assertEquals(0x00, bigEndian[0]);
        assertEquals(0x00, bigEndian[1]);
        assertEquals(0x09, bigEndian[2]);
        assertEquals((byte) 0x95, bigEndian[3]);
    }

    public void testToLittleEndian() {
        UInt32 uint32 = new UInt32(2453);
        byte[] littleEndian = uint32.toLittleEndian();
        assertEquals((byte) 0x95, littleEndian[0]);
        assertEquals(0x09, littleEndian[1]);
        assertEquals(0x00, littleEndian[2]);
        assertEquals(0x00, littleEndian[3]);
    }

    public void testAnd() {
        UInt32 one = new UInt32(0xab);
        UInt32 two = new UInt32(0xff);
        assertEquals(new UInt32(0xab), one.and(two));
    }

    public void testNot() {
        UInt32 uint32 = new UInt32(0xab);
        assertEquals(new UInt32(0xffffff54), uint32.not());
    }

    public void testOr() {
        UInt32 one = new UInt32(0xab);
        UInt32 two = new UInt32(0xf0);
        assertEquals(new UInt32(0xfb), one.or(two));
    }

    public void testXor() {
        UInt32 one = new UInt32(0xab);
        UInt32 two = new UInt32(0xf0);
        assertEquals(new UInt32(0x5b), one.xor(two));
    }

    public void testAddBitmask() {
        UInt32 uint32 = new UInt32(0x02);
        assertEquals(new UInt32(0x06), uint32.addBitmask(new UInt32(0x04)));
    }

    public void testHasBitmask() {
        UInt32 uint32 = new UInt32(0x06);
        assertTrue(uint32.hasBitmask(new UInt32(0x04)));
    }

    public void testRemoveBitmask() {
        UInt32 uint32 = new UInt32(0x06);
        assertEquals(new UInt32(0x02), uint32.removeBitmask(new UInt32(0x04)));
    }
}
