/*
 * Copyright 2002-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.sf.json.sample;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Andres Almiray <a href="mailto:aalmiray@users.sourceforge.net">aalmiray@users.sourceforge.net</a>
 */
public class NumberArrayBean {
    private byte[] bytes;
    private double[] doubles;
    private float[] floats;
    private int[] ints;
    private long[] longs;
    private short[] shorts;

    public byte[] getBytes() {
        return bytes;
    }

    public double[] getDoubles() {
        return doubles;
    }

    public float[] getFloats() {
        return floats;
    }

    public int[] getInts() {
        return ints;
    }

    public long[] getLongs() {
        return longs;
    }

    public short[] getShorts() {
        return shorts;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public void setDoubles(double[] doubles) {
        this.doubles = doubles;
    }

    public void setFloats(float[] floats) {
        this.floats = floats;
    }

    public void setInts(int[] ints) {
        this.ints = ints;
    }

    public void setLongs(long[] longs) {
        this.longs = longs;
    }

    public void setShorts(short[] shorts) {
        this.shorts = shorts;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
