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

import net.sourceforge.juint.Int8;
import junit.framework.TestCase;

public class TestInt8 extends TestCase {
    public void testByteConstructor() {
        Int8 int8 = new Int8((byte) -128);
        assertEquals(-128, int8.int8Value());
    }

    public void testShortConstructor() {
        Int8 int8 = new Int8((short) 100);
        assertEquals(100, int8.int8Value());
    }

    public void testIntConstructor() {
        Int8 int8 = new Int8(-100);
        assertEquals(-100, int8.int8Value());
    }

    public void testLongConstructor() {
        Int8 int8 = new Int8(100L);
        assertEquals(100, int8.int8Value());
    }

    public void testShortConstructorOverflow() {
        Int8 int8 = new Int8(Short.MAX_VALUE);
        assertEquals(-1, int8.int8Value());
    }

    public void testIntConstructorOverflow() {
        Int8 int8 = new Int8(Integer.MAX_VALUE);
        assertEquals(-1, int8.int8Value());
    }

    public void testLongConstructorOverflow() {
        Int8 int8 = new Int8(Long.MAX_VALUE);
        assertEquals(-1, int8.int8Value());
    }

    public void testMaxValue() {
        Int8 int8 = new Int8((byte) 127);
        assertEquals(int8.int8Value(), Int8.MAX_VALUE);
    }

    public void testShortValue() {
        Int8 int8 = new Int8(100);
        assertEquals(100, int8.shortValue());
    }

    public void testIntValue() {
        Int8 int8 = new Int8((byte) 100);
        assertEquals(100, int8.intValue());
    }

    public void testLongValue() {
        Int8 int8 = new Int8((byte) 127);
        assertEquals(127, int8.longValue());
    }

    public void testFloatValue() {
        Int8 int8 = new Int8((byte) -12);
        assertEquals(-12.0f, int8.floatValue(), 0);
    }

    public void testDoubleValue() {
        Int8 int8 = new Int8((byte) -120);
        assertEquals(-120.0d, int8.doubleValue(), 0);
    }

    public void testCompareToMore() {
        Int8 one = new Int8((byte) 1);
        Int8 two = new Int8((byte) 10);
        assertEquals(-9, one.compareTo(two));
    }

    public void testCompareToLess() {
        Int8 one = new Int8((byte) 10);
        Int8 two = new Int8((byte) 1);
        assertEquals(9, one.compareTo(two));
    }

    public void testCompareToEquals() {
        Int8 one = new Int8((byte) 1);
        Int8 two = new Int8((byte) 1);
        assertEquals(0, one.compareTo(two));
    }

    public void testHashCode() {
        Int8 int8 = new Int8((byte) 10);
        assertEquals(int8.intValue(), int8.hashCode());
    }

    public void testEquals() {
        Int8 one = new Int8((byte) 1);
        Int8 two = new Int8((byte) 1);
        assertTrue(one.equals(two));
    }

    public void testToString() {
        Int8 int8 = new Int8((byte) 127);
        assertEquals("127", int8.toString());
    }

    public void testByteValue() {
        Int8 int8 = new Int8((byte) 255);
        assertEquals(-1, int8.byteValue());
    }

    public void testAnd() {
        Int8 one = new Int8(0xab);
        Int8 two = new Int8(0xff);
        assertEquals(new Int8(0xab), one.and(two));
    }

    public void testNot() {
        Int8 int8 = new Int8(0xab);
        assertEquals(new Int8(0x54), int8.not());
    }

    public void testOr() {
        Int8 one = new Int8(0xab);
        Int8 two = new Int8(0xf0);
        assertEquals(new Int8(0xfb), one.or(two));
    }

    public void testXor() {
        Int8 one = new Int8(0xab);
        Int8 two = new Int8(0xf0);
        assertEquals(new Int8(0x5b), one.xor(two));
    }

    public void testAddBitmask() {
        Int8 int8 = new Int8(0x02);
        assertEquals(new Int8(0x06), int8.addBitmask(new Int8(0x04)));
    }

    public void testHasBitmask() {
        Int8 int8 = new Int8(0x06);
        assertTrue(int8.hasBitmask(new Int8(0x04)));
    }

    public void testRemoveBitmask() {
        Int8 int8 = new Int8(0x06);
        assertEquals(new Int8(0x02), int8.removeBitmask(new Int8(0x04)));
    }
}
