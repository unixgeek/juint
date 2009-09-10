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
 * Signed 32-bit integer.
 */
public class Int32 extends Number implements Serializable, Comparable<Int32>, Bitwise<Int32> {
    /**
     * The largest possible value.
     * <p>
     * {@value}
     */
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    /**
     * The smallest possible value.
     * <p>
     * {@value}
     */
    public static final int MIN_VALUE = Integer.MIN_VALUE;
    private int int32;

    /**
     * Creates a new instance from a <code>byte</code> array. The array must have a length of 4
     * and be in big-endian byte order.
     * 
     * @param doubleWord
     *            the value to be represented
     * @throws IllegalArgumentException
     *             if <code>doubleWord</code> is <code>null</code> or if the length does not
     *             equal 4
     */
    public Int32(byte[] doubleWord) throws IllegalArgumentException {
        verify(doubleWord);
        int32 = (doubleWord[0] & 0xff) << 24 | (doubleWord[1] & 0xff) << 16
                | (doubleWord[2] & 0xff) << 8 | (doubleWord[3] & 0xff);
    }

    /**
     * Creates a new instance from a <code>short</code>.
     * 
     * @param doubleWord
     *            the value to be represented
     */
    public Int32(short doubleWord) {
        int32 = doubleWord;
    }

    /**
     * Creates a new instance from an <code>int</code>.
     * 
     * @param doubleWord
     *            the value to be represented
     */
    public Int32(int doubleWord) {
        int32 = doubleWord;
    }

    /**
     * Creates a new instance from a <code>long</code>.
     * 
     * @param doubleWord
     *            the value to be represented
     */
    public Int32(long doubleWord) {
        int32 = (int) doubleWord;
    }

    /**
     * Creates a new instance from a <code>byte</code> array. The array must have a length of 4
     * and be in big-endian byte order.
     * 
     * @param doubleWord
     *            the value to be represented
     * @throws IllegalArgumentException
     *             if <code>doubleWord</code> is <code>null</code> or if the length does not
     *             equal 4
     */
    public static Int32 valueOfBigEndian(byte[] doubleWord) throws IllegalArgumentException {
        verify(doubleWord);
        return new Int32(doubleWord);
    }

    /**
     * Creates a new instance from a <code>byte</code> array. The array must have a length of 4
     * and be in little-endian byte order.
     * 
     * @param doubleWord
     *            the value to be represented
     * @throws IllegalArgumentException
     *             if <code>doubleWord</code> is <code>null</code> or if the length does not
     *             equal 4
     */
    public static Int32 valueOfLittleEndian(byte[] doubleWord) throws IllegalArgumentException {
        verify(doubleWord);
        byte[] reversed = new byte[4];
        reversed[0] = doubleWord[3];
        reversed[1] = doubleWord[2];
        reversed[2] = doubleWord[1];
        reversed[3] = doubleWord[0];
        return new Int32(reversed);
    }

    /**
     * Gets the value as a signed 32-bit integer.
     * 
     * @return the value as a signed 32-bit integer
     */
    public int int32Value() {
        return intValue();
    }

    /**
     * Gets the value as an <code>int</code>.
     * 
     * @return the value as an <code>int</code>
     */
    public int intValue() {
        return int32;
    }

    /**
     * Gets the value as a <code>long</code>.
     * 
     * @return the value as a <code>long</code>
     */
    public long longValue() {
        return int32;
    }

    /**
     * Gets the value as a <code>float</code>.
     * 
     * @return the value as a <code>float</code>
     */
    public float floatValue() {
        return int32;
    }

    /**
     * Gets the value as a <code>double</code>.
     * 
     * @return the value as a <code>double</code>
     */
    public double doubleValue() {
        return int32;
    }

    /**
     * Compares this <code>Int32</code> to another <code>Int32</code> for order.
     * 
     * @param object
     *            a <code>Int32</code>
     */
    public int compareTo(Int32 object) {
        if (equals(object))
            return 0;
        else {
            return (intValue() - object.intValue());
        }
    }

    /**
     * Gets the value as a <code>byte</code> array. The array will be in litte-endian byte order
     * and have a length of 4.
     * 
     * @return the value as a little-endian <code>byte</code> array
     */
    public boolean equals(Object object) {
        return ((object instanceof Int32) && ((Int32) object).intValue() == intValue());
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
     * Gets the value as a <code>byte</code> array. The array will be in big-endian byte order and
     * have a length of 4.
     * 
     * @return the value as a big-endian <code>byte</code> array
     */
    public byte[] toBigEndian() {
        byte[] doulbeWord = new byte[4];
        doulbeWord[0] = (byte) ((int32 >> 24) & 0xff);
        doulbeWord[1] = (byte) ((int32 >> 16) & 0xff);
        doulbeWord[2] = (byte) ((int32 >> 8) & 0xff);
        doulbeWord[3] = (byte) (int32 & 0xff);
        return doulbeWord;
    }

    /**
     * Gets the value as a <code>byte</code> array. The array will be in litte-endian byte order
     * and have a length of 4.
     * 
     * @return the value as a little-endian <code>byte</code> array
     */
    public byte[] toLittleEndian() {
        byte[] doulbeWord = new byte[4];
        doulbeWord[0] = (byte) (int32 & 0xff);
        doulbeWord[1] = (byte) ((int32 >> 8) & 0xff);
        doulbeWord[2] = (byte) ((int32 >> 16) & 0xff);
        doulbeWord[3] = (byte) ((int32 >> 24) & 0xff);
        return doulbeWord;
    }

    /**
     * Gets the value as a <code>String</code>.
     * 
     * @return the value as a <code>String</code>
     */
    public String toString() {
        return Integer.toString(int32);
    }

    private static void verify(byte[] doubleWord) throws IllegalArgumentException {
        if (doubleWord == null)
            throw new IllegalArgumentException("doubleWord cannot be null.");
        if (doubleWord.length != 4)
            throw new IllegalArgumentException(
                    "Invalid length for byte array.  doubleWord must be four bytes long.");
    }

    public Int32 and(Int32 number) {
        return new Int32(int32Value() & number.int32Value());
    }

    public Int32 not() {
        return new Int32(~int32Value());
    }

    public Int32 or(Int32 number) {
        return new Int32(int32Value() | number.int32Value());
    }

    public Int32 xor(Int32 number) {
        return new Int32(int32Value() ^ number.int32Value());
    }

    public Int32 addBitmask(Int32 bitmask) {
        return this.or(bitmask);
    }

    public boolean hasBitmask(Int32 bitmask) {
        return this.and(bitmask).equals(bitmask);
    }

    public Int32 removeBitmask(Int32 bitmask) {
        return this.and(bitmask.not());
    }
}
