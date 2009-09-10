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

import java.io.Serializable;

/**
 * Unsigned 16-bit integer.
 */
public class UInt16 extends Number implements Serializable, Comparable<UInt16>, Bitwise<UInt16> {
    /**
     * The largest possible value.
     * <p>
     * {@value}
     */
    public static final int MAX_VALUE = 65535;
    /**
     * The smallest possible value.
     * <p>
     * {@value}
     */
    public static final int MIN_VALUE = 0;
    private short uint16;

    /**
     * Creates a new instance from a <code>byte</code> array. The array must have a length of 2
     * and be in big-endian byte order.
     * 
     * @param word
     *            the value to be represented
     * @throws IllegalArgumentException
     *             if <code>word</code> is <code>null</code> or if the length does not equal 2
     */
    public UInt16(byte[] word) throws IllegalArgumentException {
        verify(word);
        uint16 = (short) (((word[0] & 0xff) << 8) | (word[1] & 0xff));
    }

    /**
     * Creates a new instance from a <code>short</code>.
     * 
     * @param word
     *            the value to be represented
     */
    public UInt16(short word) {
        uint16 = word;
    }

    /**
     * Creates a new instance from an <code>int</code>.
     * 
     * @param word
     *            the value to be represented
     */
    public UInt16(int word) {
        uint16 = (short) word;
    }

    /**
     * Creates a new instance from a <code>long</code>.
     * 
     * @param word
     *            the value to be represented
     */
    public UInt16(long word) {
        uint16 = (short) word;
    }

    /**
     * Creates a new instance from a <code>byte</code> array. The array must have a length of 2
     * and be in big-endian byte order.
     * 
     * @param word
     *            the value to be represented
     * @throws IllegalArgumentException
     *             if <code>word</code> is <code>null</code> or if the length does not equal 2
     */
    public static UInt16 valueOfBigEndian(byte[] word) throws IllegalArgumentException {
        verify(word);
        return new UInt16(word);
    }

    /**
     * Creates a new instance from a <code>byte</code> array. The array must have a length of 2
     * and be in little-endian byte order.
     * 
     * @param word
     *            the value to be represented
     * @throws IllegalArgumentException
     *             if <code>word</code> is <code>null</code> or if the length does not equal 2
     */
    public static UInt16 valueOfLittleEndian(byte[] word) throws IllegalArgumentException {
        verify(word);
        byte[] reversed = new byte[2];
        reversed[0] = word[1];
        reversed[1] = word[0];
        return new UInt16(reversed);
    }

    /**
     * Gets the value as an unsigned 16-bit integer.
     * 
     * @return the value as an unsigned 16-bit integer
     */
    public int uint16Value() {
        return (uint16 & 0xffff);
    }

    /**
     * Gets the value as an <code>int</code>.
     * 
     * @return the value as an <code>int</code>
     */
    public int intValue() {
        return uint16Value();
    }

    /**
     * Gets the value as a <code>long</code>.
     * 
     * @return the value as a <code>long</code>
     */
    public long longValue() {
        return uint16Value();
    }

    /**
     * Gets the value as a <code>float</code>.
     * 
     * @return the value as a <code>float</code>
     */
    public float floatValue() {
        return uint16Value();
    }

    /**
     * Gets the value as a <code>double</code>.
     * 
     * @return the value as a <code>double</code>
     */
    public double doubleValue() {
        return uint16Value();
    }

    /**
     * Gets the value as a <code>byte</code> array. The array will be in big-endian byte order and
     * have a length of 2.
     * 
     * @return the value as a big-endian <code>byte</code> array
     */
    public byte[] toBigEndian() {
        byte[] word = new byte[2];
        word[0] = (byte) ((uint16 >> 8) & 0xff);
        word[1] = (byte) (uint16 & 0xff);
        return word;
    }

    /**
     * Gets the value as a <code>byte</code> array. The array will be in litte-endian byte order
     * and have a length of 2.
     * 
     * @return the value as a little-endian <code>byte</code> array
     */
    public byte[] toLittleEndian() {
        byte[] word = new byte[2];
        word[0] = (byte) (uint16 & 0xff);
        word[1] = (byte) ((uint16 >> 8) & 0xff);
        return word;
    }

    /**
     * Compares this <code>UInt16</code> to another <code>UInt16</code> for order.
     * 
     * @param object
     *            a <code>UInt16</code>
     */
    public int compareTo(UInt16 object) {
        if (equals(object))
            return 0;
        else {
            return (uint16Value() - object.uint16Value());
        }
    }

    /**
     * Compares this <code>UInt16</code> to anoter <code>UInt16</code> for equality.
     * 
     * @param object
     *            a <code>UInt16</code>
     */
    public boolean equals(Object object) {
        return ((object instanceof UInt16) && ((UInt16) object).uint16Value() == uint16Value());
    }

    /**
     * Gets the hash code. The result is the value returned from {@link #intValue()}.
     * 
     * @return the hash code
     */
    public int hashCode() {
        return intValue();
    }

    /**
     * Gets the value as a <code>String</code>.
     * 
     * @return the value as a <code>String</code>
     */
    public String toString() {
        return Integer.toString(uint16Value());
    }

    private static void verify(byte[] word) throws IllegalArgumentException {
        if (word == null)
            throw new IllegalArgumentException("word cannot be null.");
        if (word.length != 2)
            throw new IllegalArgumentException(
                    "Invalid length for byte array.  word must be two bytes long.");
    }

    public UInt16 and(UInt16 number) {
        return new UInt16(uint16Value() & number.uint16Value());
    }

    public UInt16 not() {
        return new UInt16(~uint16Value());
    }

    public UInt16 or(UInt16 number) {
        return new UInt16(uint16Value() | number.uint16Value());
    }

    public UInt16 xor(UInt16 number) {
        return new UInt16(uint16Value() ^ number.uint16Value());
    }

    public UInt16 addBitmask(UInt16 bitmask) {
        return this.or(bitmask);
    }

    public boolean hasBitmask(UInt16 bitmask) {
        return this.and(bitmask).equals(bitmask);
    }

    public UInt16 removeBitmask(UInt16 bitmask) {
        return this.and(bitmask.not());
    }
}
