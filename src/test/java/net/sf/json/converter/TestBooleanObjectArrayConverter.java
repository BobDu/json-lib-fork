/*
 * Copyright 2002-2006 the original author or authors.
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

package net.sf.json.converter;

import junit.framework.TestCase;
import net.sf.json.Assertions;

/**
 * @author Andres Almiray
 */
public class TestBooleanObjectArrayConverter extends TestCase
{
   public static void main( String[] args )
   {
      junit.textui.TestRunner.run( TestBooleanObjectArrayConverter.class );
   }

   private BooleanObjectArrayConverter converter;

   public TestBooleanObjectArrayConverter( String name )
   {
      super( name );
   }

   public void testConvert_BooleanArray()
   {
      Boolean[] expected = { Boolean.TRUE, Boolean.FALSE };
      Boolean[] actual = (Boolean[]) converter.convert( expected );
      Assertions.assertEquals( expected, actual );
   }

   public void testConvert_BooleanArray_threedims()
   {
      Boolean[][][] expected = { { { Boolean.TRUE }, { Boolean.FALSE } },
            { { Boolean.TRUE }, { Boolean.FALSE } } };
      Boolean[][][] actual = (Boolean[][][]) converter.convert( expected );
      Assertions.assertEquals( expected, actual );
   }

   public void testConvert_BooleanArray_twodims()
   {
      Boolean[][] expected = { { Boolean.TRUE, Boolean.FALSE }, { Boolean.TRUE, Boolean.FALSE } };
      Boolean[][] actual = (Boolean[][]) converter.convert( expected );
      Assertions.assertEquals( expected, actual );
   }

   public void testConvert_null()
   {
      assertNull( converter.convert( null ) );
   }

   public void testConvert_strings()
   {
      String[] expected = { "true", "yes", "on", "false", "no", "off" };
      Boolean[] actual = (Boolean[]) converter.convert( expected );
      Assertions.assertEquals( new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
            Boolean.FALSE, Boolean.FALSE, Boolean.FALSE }, actual );
   }

   public void testConvert_strings_twodims()
   {
      String[][] expected = { { "true", "yes", "on" }, { "false", "no", "off" } };
      Boolean[][] actual = (Boolean[][]) converter.convert( expected );
      Assertions.assertEquals( new Boolean[][] { { Boolean.TRUE, Boolean.TRUE, Boolean.TRUE },
            { Boolean.FALSE, Boolean.FALSE, Boolean.FALSE } }, actual );
   }

   protected void setUp() throws Exception
   {
      converter = new BooleanObjectArrayConverter();
   }
}