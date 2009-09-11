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
 * Signed 16-bit integer.
 */
public class Int16 extends Number implements Serializable, Comparable<Int16>, Bitwise<Int16> {
    private static final long serialVersionUID = -2975897484063142953L;
    /**
     * The largest possible value.
     * <p>
     * {@value}
     */
    public static final short MAX_VALUE = Short.MAX_VALUE;
    /**
     * The smallest possible value.
     * <p>
     * {@value}
     */
    public static final short MIN_VALUE = Short.MIN_VALUE;
    private short int16;

    /**
     * Creates a new instance from a <code>byte</code> array. The array must have a length of 2
     * and be in big-endian byte order.
     * 
     * @param word
     *            the value to be represented
     * @throws IllegalArgumentException
     *             if <code>word</code> is <code>null</code> or if the length does not equal 2
     */
    public Int16(byte[] word) throws IllegalArgumentException {
        verify(word);
        int16 = (short) (((word[0] & 0xff) << 8) | (word[1] & 0xff));
    }

    /**
     * Creates a new instance from a <code>short</code>.
     * 
     * @param word
     *            the value to be represented
     */
    public Int16(short word) {
        int16 = word;
    }

    /**
     * Creates a new instance from an <code>int</code>.
     * 
     * @param word
     *            the value to be represented
     */
    public Int16(int word) {
        int16 = (short) word;
    }

    /**
     * Creates a new instance from a <code>long</code>.
     * 
     * @param word
     *            the value to be represented
     */
    public Int16(long word) {
        int16 = (short) word;
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
    public static Int16 valueOfBigEndian(byte[] word) throws IllegalArgumentException {
        verify(word);
        return new Int16(word);
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
    public static Int16 valueOfLittleEndian(byte[] word) throws IllegalArgumentException {
        verify(word);
        byte[] reversed = new byte[2];
        reversed[0] = word[1];
        reversed[1] = word[0];
        return new Int16(reversed);
    }

    /**
     * Gets the value as an unsigned 16-bit integer.
     * 
     * @return the value as an unsigned 16-bit integer
     */
    public short int16Value() {
        return shortValue();
    }

    /**
     * Gets the value as an <code>int</code>.
     * 
     * @return the value as an <code>int</code>
     */
    public int intValue() {
        return int16;
    }

    /**
     * Gets the value as a <code>long</code>.
     * 
     * @return the value as a <code>long</code>
     */
    public long longValue() {
        return int16;
    }

    /**
     * Gets the value as a <code>float</code>.
     * 
     * @return the value as a <code>float</code>
     */
    public float floatValue() {
        return int16;
    }

    /**
     * Gets the value as a <code>double</code>.
     * 
     * @return the value as a <code>double</code>
     */
    public double doubleValue() {
        return int16;
    }

    /**
     * Gets the value as a <code>byte</code> array. The array will be in big-endian byte order and
     * have a length of 2.
     * 
     * @return the value as a big-endian <code>byte</code> array
     */
    public byte[] toBigEndian() {
        byte[] word = new byte[2];
        word[0] = (byte) ((int16 >> 8) & 0xff);
        word[1] = (byte) (int16 & 0xff);
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
        word[0] = (byte) (int16 & 0xff);
        word[1] = (byte) ((int16 >> 8) & 0xff);
        return word;
    }

    /**
     * Compares this <code>Int16</code> to another <code>Int16</code> for order.
     * 
     * @param object
     *            a <code>Int16</code>
     */
    public int compareTo(Int16 object) {
        if (equals(object))
            return 0;
        else {
            return (shortValue() - object.shortValue());
        }
    }

    /**
     * Compares this <code>Int16</code> to anoter <code>Int16</code> for equality.
     * 
     * @param object
     *            a <code>Int16</code>
     */
    public boolean equals(Object object) {
        return ((object instanceof Int16) && ((Int16) object).shortValue() == shortValue());
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
        return Short.toString(int16);
    }

    private static void verify(byte[] word) throws IllegalArgumentException {
        if (word == null)
            throw new IllegalArgumentException("word cannot be null.");
        if (word.length != 2)
            throw new IllegalArgumentException(
                    "Invalid length for byte array.  word must be two bytes long.");
    }

    public Int16 and(Int16 number) {
        return new Int16(int16Value() & number.int16Value());
    }

    public Int16 not() {
        return new Int16(~int16Value());
    }

    public Int16 or(Int16 number) {
        return new Int16(int16Value() | number.int16Value());
    }

    public Int16 xor(Int16 number) {
        return new Int16(int16Value() ^ number.int16Value());
    }

    public Int16 addBitmask(Int16 bitmask) {
        return this.or(bitmask);
    }

    public boolean hasBitmask(Int16 bitmask) {
        return this.and(bitmask).equals(bitmask);
    }

    public Int16 removeBitmask(Int16 bitmask) {
        return this.and(bitmask.not());
    }
}
