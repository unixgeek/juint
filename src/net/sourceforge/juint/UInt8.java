/*
 * $Id: UInt8.java 32 2007-09-29 13:45:46Z gunter $
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
 * Unsigned 8-bit integer.
 */
public class UInt8 extends Number implements Serializable, Comparable, Bitwise<UInt8> {
    /**
     * The largest possible value.
     * <p>
     * {@value}
     */
    public static final short MAX_VALUE = 255;
    /**
     * The smallest possible value.
     * <p>
     * {@value}
     */
    public static final short MIN_VALUE = 0;
    private byte uint8;

    /**
     * Creates a new instance from a <code>byte</code>.
     * 
     * @param bite
     *            the value to be represented
     */
    public UInt8(byte bite) {
        uint8 = bite;
    }

    /**
     * Creates a new instance from a <code>short</code>.
     * 
     * @param bite
     *            the value to be represented
     */
    public UInt8(short bite) {
        uint8 = (byte) bite;
    }

    /**
     * Creates a new instance from an <code>int</code>.
     * 
     * @param bite
     *            the value to be represented
     */
    public UInt8(int bite) {
        uint8 = (byte) bite;
    }

    /**
     * Creates a new instance from a <code>long</code>.
     * 
     * @param bite
     *            the value to be represented
     */
    public UInt8(long bite) {
        uint8 = (byte) bite;
    }

    /**
     * Gets the value as an unsigned 8-bit integer.
     * 
     * @return the value as an unsigned 8-bit integer
     */
    public short uint8Value() {
        return (short) (uint8 & 0xff);
    }

    /**
     * Gets the value as a <code>short</code>.
     * 
     * @return the value as a <code>short</code>
     */
    public short shortValue() {
        return uint8Value();
    }

    /**
     * Gets the value as an <code>int</code>.
     * 
     * @return the value as an <code>int</code>
     */
    public int intValue() {
        return uint8Value();
    }

    /**
     * Gets the value as a <code>long</code>.
     * 
     * @return the value as a <code>long</code>
     */
    public long longValue() {
        return uint8Value();
    }

    /**
     * Gets the value as a <code>float</code>.
     * 
     * @return the value as a <code>float</code>
     */
    public float floatValue() {
        return uint8Value();
    }

    /**
     * Gets the value as a <code>double</code>.
     * 
     * @return the value as a <code>double</code>
     */
    public double doubleValue() {
        return uint8Value();
    }

    /**
     * Compares this <code>UInt8</code> to another <code>UInt8</code> for order.
     * 
     * @param object
     *            a <code>UInt8</code>
     */
    public int compareTo(Object object) {
        if (equals(object))
            return 0;
        else {
            return (uint8Value() - ((UInt8) object).uint8Value());
        }
    }

    /**
     * Compares this <code>UInt8</code> to anoter <code>UInt8</code> for equality.
     * 
     * @param object
     *            a <code>UInt8</code>
     */
    public boolean equals(Object object) {
        return ((object instanceof UInt8) && ((UInt8) object).uint8Value() == uint8Value());
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
        return Short.toString(uint8Value());
    }

    public UInt8 and(UInt8 number) {
        return new UInt8(uint8Value() & number.uint8Value());
    }

    public UInt8 not() {
        return new UInt8(~uint8Value());
    }

    public UInt8 or(UInt8 number) {
        return new UInt8(uint8Value() | number.uint8Value());
    }

    public UInt8 xor(UInt8 number) {
        return new UInt8(uint8Value() ^ number.uint8Value());
    }

    public UInt8 addBitmask(UInt8 bitmask) {
        return this.or(bitmask);
    }

    public boolean hasBitmask(UInt8 bitmask) {
        return this.and(bitmask).equals(bitmask);
    }

    public UInt8 removeBitmask(UInt8 bitmask) {
        return this.and(bitmask.not());
    }
}
