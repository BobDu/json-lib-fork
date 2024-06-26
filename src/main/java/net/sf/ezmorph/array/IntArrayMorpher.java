/*
 * Copyright 2006-2007 the original author or authors.
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

package net.sf.ezmorph.array;

import java.lang.reflect.Array;
import net.sf.ezmorph.MorphException;
import net.sf.ezmorph.primitive.IntMorpher;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Morphs an array to a int[].
 *
 * @author Andres Almiray <a href="mailto:aalmiray@users.sourceforge.net">aalmiray@users.sourceforge.net</a>
 */
public final class IntArrayMorpher extends AbstractArrayMorpher {
    private static final Class INT_ARRAY_CLASS = int[].class;
    private int defaultValue;

    public IntArrayMorpher() {
        super(false);
    }

    /**
     * @param defaultValue return value if the value to be morphed is null
     */
    public IntArrayMorpher(int defaultValue) {
        super(true);
        this.defaultValue = defaultValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof IntArrayMorpher)) {
            return false;
        }

        IntArrayMorpher other = (IntArrayMorpher) obj;
        EqualsBuilder builder = new EqualsBuilder();
        if (isUseDefault() && other.isUseDefault()) {
            builder.append(getDefaultValue(), other.getDefaultValue());
            return builder.isEquals();
        } else if (!isUseDefault() && !other.isUseDefault()) {
            return builder.isEquals();
        } else {
            return false;
        }
    }

    /**
     * Returns the default value for this Morpher.
     */
    public int getDefaultValue() {
        return defaultValue;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        if (isUseDefault()) {
            builder.append(getDefaultValue());
        }
        return builder.toHashCode();
    }

    @Override
    public Object morph(Object array) {
        if (array == null) {
            return null;
        }

        if (INT_ARRAY_CLASS.isAssignableFrom(array.getClass())) {
            // no conversion needed
            return (int[]) array;
        }

        if (array.getClass().isArray()) {
            int length = Array.getLength(array);
            int dims = getDimensions(array.getClass());
            int[] dimensions = createDimensions(dims, length);
            Object result = Array.newInstance(int.class, dimensions);
            IntMorpher morpher = isUseDefault() ? new IntMorpher(defaultValue) : new IntMorpher();
            if (dims == 1) {
                for (int index = 0; index < length; index++) {
                    Array.set(result, index, new Integer(morpher.morph(Array.get(array, index))));
                }
            } else {
                for (int index = 0; index < length; index++) {
                    Array.set(result, index, morph(Array.get(array, index)));
                }
            }
            return result;
        } else {
            throw new MorphException("argument is not an array: " + array.getClass());
        }
    }

    @Override
    public Class morphsTo() {
        return INT_ARRAY_CLASS;
    }
}
