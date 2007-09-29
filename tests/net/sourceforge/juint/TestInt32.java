/*
 * $Id$
 * 
 * Copyright (c) 2006, Gunter Wambaugh
 * 
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *    * Redistributions of source code must retain the above copyright notice,
 *      this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *    * Neither the name of the author nor the names of its contributors may be
 *      used to endorse or promote products derived from this software without 
 *      specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.sourceforge.juint;

import net.sourceforge.juint.Int32;
import junit.framework.TestCase;

public class TestInt32 extends TestCase {
    public void testByteConstructor() {
        byte[] doubleWord = new byte[4];
        // doubleWord = -2097149412
        doubleWord[0] = (byte) 0x83;
        doubleWord[1] = (byte) 0x00;
        doubleWord[2] = (byte) 0x0a;
        doubleWord[3] = (byte) 0x1c;
        Int32 int32 = new Int32(doubleWord);
        assertEquals(-2097149412, int32.int32Value());
    }

    public void testShortConstructor() {
        Int32 int32 = new Int32((short) 130);
        assertEquals(130, int32.int32Value());
    }

    public void testIntConstructor() {
        Int32 int32 = new Int32(-100);
        assertEquals(-100, int32.int32Value());
    }

    public void testLongConstructor() {
        Int32 int32 = new Int32(100L);
        assertEquals(100, int32.int32Value());
    }

    public void testLongConstructorOverflow() {
        Int32 int32 = new Int32(Long.MAX_VALUE);
        assertEquals(-1, int32.int32Value());
    }

    public void testConstructorException() {
        byte[] doubleWord = new byte[3];
        doubleWord[0] = 1;
        doubleWord[1] = 2;
        doubleWord[2] = 3;
        try {
            new Int32(doubleWord);
            fail("Should raise an IllegalArgumentException.");
        }
        catch (IllegalArgumentException e) {
        }
    }

    public void testConstructorNullDoubleWord() {
        try {
            new Int32(null);
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
        Int32 int32 = Int32.valueOfBigEndian(doubleWord);
        assertEquals(-896331759, int32.int32Value());
    }

    public void testValueOfLittleEndian() {
        byte[] doubleWord = new byte[4];
        doubleWord[0] = (byte) 0xca;
        doubleWord[1] = (byte) 0x93;
        doubleWord[2] = 0x10;
        doubleWord[3] = 0x11;
        Int32 int32 = Int32.valueOfLittleEndian(doubleWord);
        assertEquals(286299082, int32.int32Value());
    }

    public void testMaxValue() {
        Int32 int32 = new Int32(2147483647L);
        assertEquals(Int32.MAX_VALUE, int32.int32Value());
    }

    public void testShortValue() {
        Int32 int32 = new Int32(1000);
        assertEquals(1000, int32.shortValue());
    }

    public void testIntValue() {
        Int32 int32 = new Int32(20000);
        assertEquals(20000, int32.intValue());
    }

    public void testLongValue() {
        Int32 int32 = new Int32(20001);
        assertEquals(20001, int32.longValue());
    }

    public void testFloatValue() {
        Int32 int32 = new Int32(20002);
        assertEquals(20002.0f, int32.floatValue(), 0);
    }

    public void testDoubleValue() {
        Int32 int32 = new Int32(1978);
        assertEquals(1978.0d, int32.doubleValue(), 0);
    }

    public void testCompareToMore() {
        Int32 one = new Int32(1);
        Int32 two = new Int32(10);
        assertEquals(-9, one.compareTo(two));
    }

    public void testCompareToLess() {
        Int32 one = new Int32(10);
        Int32 two = new Int32(1);
        assertEquals(9, one.compareTo(two));
    }

    public void testCompareToEquals() {
        Int32 one = new Int32((byte) 1);
        Int32 two = new Int32((byte) 1);
        assertEquals(0, one.compareTo(two));
    }

    public void testHashCode() {
        Int32 int32 = new Int32((byte) 10);
        assertEquals(int32.intValue(), int32.hashCode());
    }

    public void testEquals() {
        Int32 one = new Int32(1);
        Int32 two = new Int32(1);
        assertTrue(one.equals(two));
    }

    public void testToString() {
        Int32 int32 = new Int32(65290);
        assertEquals("65290", int32.toString());
    }

    public void testByteValue() {
        byte[] doubleWord = new byte[4];
        // doubleWord = 4278897153
        doubleWord[0] = (byte) 0xff;
        doubleWord[1] = 0x0a;
        doubleWord[2] = (byte) 0xca;
        doubleWord[3] = 0x01;
        Int32 int32 = new Int32(doubleWord);
        assertEquals(1, int32.byteValue());
    }

    public void testToBigEndian() {
        Int32 int32 = new Int32(2453);
        byte[] bigEndian = int32.toBigEndian();
        assertEquals(0x00, bigEndian[0]);
        assertEquals(0x00, bigEndian[1]);
        assertEquals(0x09, bigEndian[2]);
        assertEquals((byte) 0x95, bigEndian[3]);
    }

    public void testToLittleEndian() {
        Int32 int32 = new Int32(2453);
        byte[] littleEndian = int32.toLittleEndian();
        assertEquals((byte) 0x95, littleEndian[0]);
        assertEquals(0x09, littleEndian[1]);
        assertEquals(0x00, littleEndian[2]);
        assertEquals(0x00, littleEndian[3]);
    }

    public void testAnd() {
        Int32 one = new Int32(0xab);
        Int32 two = new Int32(0xff);
        assertEquals(new Int32(0xab), one.and(two));
    }

    public void testNot() {
        Int32 int32 = new Int32(0xab);
        assertEquals(new Int32(0xffffff54), int32.not());
    }

    public void testOr() {
        Int32 one = new Int32(0xab);
        Int32 two = new Int32(0xf0);
        assertEquals(new Int32(0xfb), one.or(two));
    }

    public void testXor() {
        Int32 one = new Int32(0xab);
        Int32 two = new Int32(0xf0);
        assertEquals(new Int32(0x5b), one.xor(two));
    }

    public void testAddBitmask() {
        Int32 int32 = new Int32(0x02);
        assertEquals(new Int32(0x06), int32.addBitmask(new Int32(0x04)));
    }

    public void testHasBitmask() {
        Int32 int32 = new Int32(0x06);
        assertTrue(int32.hasBitmask(new Int32(0x04)));
    }

    public void testRemoveBitmask() {
        Int32 int32 = new Int32(0x06);
        assertEquals(new Int32(0x02), int32.removeBitmask(new Int32(0x04)));
    }
}
