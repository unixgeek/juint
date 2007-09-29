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

/**
 * Bitwise operations.
 * 
 * @param <T>
 */
public interface Bitwise<T> {

    /**
     * Logical and.
     * 
     * @param number
     * @return the result of the and
     */
    T and(T number);

    /**
     * Logical or.
     * 
     * @param number
     * @return the result of the or
     */
    T or(T number);

    /**
     * Logical xor.
     * 
     * @param number
     * @return the result of the xor
     */
    T xor(T number);

    /**
     * Logical not.
     * 
     * @return the result of the not
     */
    T not();

    /**
     * Determines if this number has the given bitmask.
     * 
     * @param bitmask
     * @return <code>true</code> if the number has the bitmask; <code>false</code> otherwise
     */
    boolean hasBitmask(T bitmask);

    /**
     * Sets the bits in the given bitmask.
     * 
     * @param bitmask
     * @return the number with the bits set
     */
    T addBitmask(T bitmask);

    /**
     * Unsets the bits in the given bitmask.
     * 
     * @param bitmask
     * @return the number with the bits unset
     */
    T removeBitmask(T bitmask);
}
