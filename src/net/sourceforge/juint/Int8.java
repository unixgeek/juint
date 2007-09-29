/*
 * $Id: Int8.java 32 2007-09-29 13:45:46Z gunter $
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
 * Signed 8-bit integer.
 */
public class Int8 extends Number implements Serializable, Comparable, Bitwise<Int8> {
    /**
     * The largest possible value.
     * <p>
     * {@value}
     */
    public static final byte MAX_VALUE = Byte.MAX_VALUE;
    /**
     * The smallest possible value.
     * <p>
     * {@value}
     */
    public static final byte MIN_VALUE = Byte.MIN_VALUE;
    private byte int8;

    /**
     * Creates a new instance from a <code>byte</code>.
     * 
     * @param bite
     *            the value to be represented
     */
    public Int8(byte bite) {
        int8 = bite;
    }

    /**
     * Creates a new instance from a <code>short</code>.
     * 
     * @param bite
     *            the value to be represented
     */
    public Int8(short bite) {
        int8 = (byte) bite;
    }

    /**
     * Creates a new instance from an <code>int</code>.
     * 
     * @param bite
     *            the value to be represented
     */
    public Int8(int bite) {
        int8 = (byte) bite;
    }

    /**
     * Creates a new instance from a <code>long</code>.
     * 
     * @param bite
     *            the value to be represented
     */
    public Int8(long bite) {
        int8 = (byte) bite;
    }

    /**
     * Gets the value as a signed 8-bit integer.
     * 
     * @return the value as a signed 8-bit integer
     */
    public byte int8Value() {
        return byteValue();
    }

    /**
     * Gets the value as an <code>int</code>.
     * 
     * @return the value as an <code>int</code>
     */
    public int intValue() {
        return int8;
    }

    /**
     * Gets the value as a <code>long</code>.
     * 
     * @return the value as a <code>long</code>
     */
    public long longValue() {
        return int8;
    }

    /**
     * Gets the value as a <code>float</code>.
     * 
     * @return the value as a <code>float</code>
     */
    public float floatValue() {
        return int8;
    }

    /**
     * Gets the value as a <code>double</code>.
     * 
     * @return the value as a <code>double</code>
     */
    public double doubleValue() {
        return int8;
    }

    /**
     * Compares this <code>Int8</code> to another <code>Int8</code> for order.
     * 
     * @param object
     *            a <code>Int8</code>
     */
    public int compareTo(Object object) {
        if (equals(object))
            return 0;
        else {
            return (byteValue() - ((Int8) object).byteValue());
        }
    }

    /**
     * Compares this <code>Int8</code> to anoter <code>Int8</code> for equality.
     * 
     * @param object
     *            a <code>Int8</code>
     */
    public boolean equals(Object object) {
        return ((object instanceof Int8) && ((Int8) object).byteValue() == byteValue());
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
        return Byte.toString(int8);
    }

    public Int8 and(Int8 number) {
        return new Int8(int8Value() & number.int8Value());
    }

    public Int8 not() {
        return new Int8(~int8Value());
    }

    public Int8 or(Int8 number) {
        return new Int8(int8Value() | number.int8Value());
    }

    public Int8 xor(Int8 number) {
        return new Int8(int8Value() ^ number.int8Value());
    }

    public Int8 addBitmask(Int8 bitmask) {
        return this.or(bitmask);
    }

    public boolean hasBitmask(Int8 bitmask) {
        return this.and(bitmask).equals(bitmask);
    }

    public Int8 removeBitmask(Int8 bitmask) {
        return this.and(bitmask.not());
    }
}
