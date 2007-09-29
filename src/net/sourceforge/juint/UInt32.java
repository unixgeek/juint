/*
 * $Id: UInt32.java 32 2007-09-29 13:45:46Z gunter $
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
 * Unsigned 32-bit integer.
 */
public class UInt32 extends Number implements Serializable, Comparable, Bitwise<UInt32> {
    /**
     * The largest possible value.
     * <p>
     * {@value}
     */
    public static final long MAX_VALUE = 4294967295L;
    /**
     * The smallest possible value.
     * <p>
     * {@value}
     */
    public static final long MIN_VALUE = 0;
    private int uint32;

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
    public UInt32(byte[] doubleWord) throws IllegalArgumentException {
        verify(doubleWord);
        uint32 = ((doubleWord[0] & 0xff) << 24) | ((doubleWord[1] & 0xff) << 16)
                | ((doubleWord[2] & 0xff) << 8) | (doubleWord[3] & 0xff);
    }

    /**
     * Creates a new instance from a <code>short</code>.
     * 
     * @param doubleWord
     *            the value to be represented
     */
    public UInt32(short doubleWord) {
        uint32 = doubleWord;
    }

    /**
     * Creates a new instance from an <code>int</code>.
     * 
     * @param doubleWord
     *            the value to be represented
     */
    public UInt32(int doubleWord) {
        uint32 = doubleWord;
    }

    /**
     * Creates a new instance from a <code>long</code>.
     * 
     * @param doubleWord
     *            the value to be represented
     */
    public UInt32(long doubleWord) {
        uint32 = (int) doubleWord;
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
    public static UInt32 valueOfBigEndian(byte[] doubleWord) throws IllegalArgumentException {
        verify(doubleWord);
        return new UInt32(doubleWord);
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
    public static UInt32 valueOfLittleEndian(byte[] doubleWord) throws IllegalArgumentException {
        verify(doubleWord);
        byte[] reversed = new byte[4];
        reversed[0] = doubleWord[3];
        reversed[1] = doubleWord[2];
        reversed[2] = doubleWord[1];
        reversed[3] = doubleWord[0];
        return new UInt32(reversed);
    }

    /**
     * Gets the value as an unsigned 32-bit integer.
     * 
     * @return the value as an unsigned 32-bit integer
     */
    public long uint32Value() {
        return (uint32 & 0xffffffffL);
    }

    /**
     * Gets the value as an <code>int</code>.
     * 
     * @return the value as an <code>int</code>
     */
    public int intValue() {
        return (int) uint32Value();
    }

    /**
     * Gets the value as a <code>long</code>.
     * 
     * @return the value as a <code>long</code>
     */
    public long longValue() {
        return uint32Value();
    }

    /**
     * Gets the value as a <code>float</code>.
     * 
     * @return the value as a <code>float</code>
     */
    public float floatValue() {
        return uint32Value();
    }

    /**
     * Gets the value as a <code>double</code>.
     * 
     * @return the value as a <code>double</code>
     */
    public double doubleValue() {
        return uint32Value();
    }

    /**
     * Gets the value as a <code>byte</code> array. The array will be in big-endian byte order and
     * have a length of 4.
     * 
     * @return the value as a big-endian <code>byte</code> array
     */
    public byte[] toBigEndian() {
        byte[] doulbeWord = new byte[4];
        doulbeWord[0] = (byte) ((uint32 >> 24) & 0xff);
        doulbeWord[1] = (byte) ((uint32 >> 16) & 0xff);
        doulbeWord[2] = (byte) ((uint32 >> 8) & 0xff);
        doulbeWord[3] = (byte) (uint32 & 0xff);
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
        doulbeWord[0] = (byte) (uint32 & 0xff);
        doulbeWord[1] = (byte) ((uint32 >> 8) & 0xff);
        doulbeWord[2] = (byte) ((uint32 >> 16) & 0xff);
        doulbeWord[3] = (byte) ((uint32 >> 24) & 0xff);
        return doulbeWord;
    }

    /**
     * Compares this <code>UInt32</code> to another <code>UInt32</code> for order.
     * 
     * @param object
     *            a <code>UInt32</code>
     */
    public int compareTo(Object object) {
        if (equals(object))
            return 0;
        else {
            return (int) (uint32Value() - ((UInt32) object).uint32Value());
        }
    }

    /**
     * Compares this <code>UInt32</code> to anoter <code>UInt32</code> for equality.
     * 
     * @param object
     *            a <code>UInt32</code>
     */
    public boolean equals(Object object) {
        return ((object instanceof UInt32) && ((UInt32) object).uint32Value() == uint32Value());
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
        return Long.toString(uint32Value());
    }

    private static void verify(byte[] doubleWord) throws IllegalArgumentException {
        if (doubleWord == null)
            throw new IllegalArgumentException("doubleWord cannot be null.");
        if (doubleWord.length != 4)
            throw new IllegalArgumentException(
                    "Invalid length for byte array.  doubleWord must be four bytes long.");
    }

    public UInt32 and(UInt32 number) {
        return new UInt32(uint32Value() & number.uint32Value());
    }

    public UInt32 not() {
        return new UInt32(~uint32Value());
    }

    public UInt32 or(UInt32 number) {
        return new UInt32(uint32Value() | number.uint32Value());
    }

    public UInt32 xor(UInt32 number) {
        return new UInt32(uint32Value() ^ number.uint32Value());
    }

    public UInt32 addBitmask(UInt32 bitmask) {
        return this.or(bitmask);
    }

    public boolean hasBitmask(UInt32 bitmask) {
        return this.and(bitmask).equals(bitmask);
    }

    public UInt32 removeBitmask(UInt32 bitmask) {
        return this.and(bitmask.not());
    }
}
