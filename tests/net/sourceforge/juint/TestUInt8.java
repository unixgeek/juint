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

import net.sourceforge.juint.UInt8;
import junit.framework.TestCase;

public class TestUInt8 extends TestCase {
    public void testByteConstructor() {
        UInt8 uint8 = new UInt8((byte) -128);
        assertEquals(128, uint8.shortValue());
    }

    public void testShortConstructor() {
        UInt8 uint8 = new UInt8((short) 100);
        assertEquals(100, uint8.uint8Value());
    }

    public void testIntConstructor() {
        UInt8 uint8 = new UInt8(-100);
        assertEquals(156, uint8.uint8Value());
    }

    public void testLongConstructor() {
        UInt8 uint8 = new UInt8(100L);
        assertEquals(100, uint8.uint8Value());
    }

    public void testShortConstructorOverflow() {
        UInt8 uint8 = new UInt8(Short.MAX_VALUE);
        assertEquals(UInt8.MAX_VALUE, uint8.uint8Value());
    }

    public void testIntConstructorOverflow() {
        UInt8 uint8 = new UInt8(Integer.MAX_VALUE);
        assertEquals(UInt8.MAX_VALUE, uint8.uint8Value());
    }

    public void testLongConstructorOverflow() {
        UInt8 uint8 = new UInt8(Long.MAX_VALUE);
        assertEquals(UInt8.MAX_VALUE, uint8.uint8Value());
    }

    public void testMaxValue() {
        UInt8 uint8 = new UInt8((byte) 255);
        assertEquals(uint8.uint8Value(), UInt8.MAX_VALUE);
    }

    public void testShortValue() {
        UInt8 uint8 = new UInt8(180);
        assertEquals(180, uint8.shortValue());
    }

    public void testIntValue() {
        UInt8 uint8 = new UInt8((byte) 255);
        assertEquals(255, uint8.intValue());
    }

    public void testLongValue() {
        UInt8 uint8 = new UInt8((byte) 200);
        assertEquals(200, uint8.longValue());
    }

    public void testFloatValue() {
        UInt8 uint8 = new UInt8((byte) 250);
        assertEquals(250.0f, uint8.floatValue(), 0);
    }

    public void testDoubleValue() {
        UInt8 uint8 = new UInt8((byte) 210);
        assertEquals(210.0d, uint8.doubleValue(), 0);
    }

    public void testCompareToMore() {
        UInt8 one = new UInt8((byte) 1);
        UInt8 two = new UInt8((byte) 10);
        assertEquals(-9, one.compareTo(two));
    }

    public void testCompareToLess() {
        UInt8 one = new UInt8((byte) 10);
        UInt8 two = new UInt8((byte) 1);
        assertEquals(9, one.compareTo(two));
    }

    public void testCompareToEquals() {
        UInt8 one = new UInt8((byte) 1);
        UInt8 two = new UInt8((byte) 1);
        assertEquals(0, one.compareTo(two));
    }

    public void testHashCode() {
        UInt8 uint8 = new UInt8((byte) 10);
        assertEquals(uint8.intValue(), uint8.hashCode());
    }

    public void testEquals() {
        UInt8 one = new UInt8((byte) 1);
        UInt8 two = new UInt8((byte) 1);
        assertTrue(one.equals(two));
    }

    public void testToString() {
        UInt8 uint8 = new UInt8((byte) 130);
        assertEquals("130", uint8.toString());
    }

    public void testByteValue() {
        UInt8 uint8 = new UInt8((byte) 255);
        assertEquals(-1, uint8.byteValue());
    }

    public void testAnd() {
        UInt8 one = new UInt8(0xab);
        UInt8 two = new UInt8(0xff);
        assertEquals(new UInt8(0xab), one.and(two));
    }

    public void testNot() {
        UInt8 uint8 = new UInt8(0xab);
        assertEquals(new UInt8(0x54), uint8.not());
    }

    public void testOr() {
        UInt8 one = new UInt8(0xab);
        UInt8 two = new UInt8(0xf0);
        assertEquals(new UInt8(0xfb), one.or(two));
    }

    public void testXor() {
        UInt8 one = new UInt8(0xab);
        UInt8 two = new UInt8(0xf0);
        assertEquals(new UInt8(0x5b), one.xor(two));
    }

    public void testAddBitmask() {
        UInt8 uint8 = new UInt8(0x02);
        assertEquals(new UInt8(0x06), uint8.addBitmask(new UInt8(0x04)));
    }

    public void testHasBitmask() {
        UInt8 uint8 = new UInt8(0x06);
        assertTrue(uint8.hasBitmask(new UInt8(0x04)));
    }

    public void testRemoveBitmask() {
        UInt8 uint8 = new UInt8(0x06);
        assertEquals(new UInt8(0x02), uint8.removeBitmask(new UInt8(0x04)));
    }
}
