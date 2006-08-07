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

package net.sf.json.xml;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.custommonkey.xmlunit.XMLTestCase;

/**
 * @author Andres Almiray
 */
public class TestXMLSerializer_writes extends XMLTestCase
{
   public static void main( String[] args )
   {
      junit.textui.TestRunner.run( TestXMLSerializer_writes.class );
   }

   public TestXMLSerializer_writes( String testName )
   {
      super( testName );
   }

   public void testWriteBooleanArray() throws Exception
   {
      JSONArray jsonArray = new JSONArray( "[true,false]" );
      String expected = "<a><e type=\"boolean\">true</e><e type=\"boolean\">false</e></a>";
      String xml = XMLSerializer.write( jsonArray );
      assertXMLEqual( expected, xml );
   }

   public void testWriteMultiBooleanArray() throws Exception
   {
      JSONArray jsonArray = new JSONArray( "[true,false,[true,false]]" );
      String expected = "<a><e type=\"boolean\">true</e><e type=\"boolean\">false</e><e class=\"array\"><e type=\"boolean\">true</e><e type=\"boolean\">false</e></e></a>";
      String xml = XMLSerializer.write( jsonArray );
      assertXMLEqual( expected, xml );
   }

   public void testWriteMultiNumberArray() throws Exception
   {
      JSONArray jsonArray = new JSONArray( "[1.1,2,[3,4.4]]" );
      String expected = "<a><e type=\"number\">1.1</e><e type=\"number\">2</e><e class=\"array\"><e type=\"number\">3</e><e type=\"number\">4.4</e></e></a>";
      String xml = XMLSerializer.write( jsonArray );
      assertXMLEqual( expected, xml );
   }

   public void testWriteMultiStringArray() throws Exception
   {
      JSONArray jsonArray = new JSONArray( "['1.1','2',['3','4.4']]" );
      String expected = "<a><e type=\"string\">1.1</e><e type=\"string\">2</e><e class=\"array\"><e type=\"string\">3</e><e type=\"string\">4.4</e></e></a>";
      String xml = XMLSerializer.write( jsonArray );
      assertXMLEqual( expected, xml );
   }

   public void testWriteNullObject() throws Exception
   {
      JSONObject jsonObject = new JSONObject( true );
      String expected = "<o null=\"true\"/>";
      String xml = XMLSerializer.write( jsonObject );
      assertXMLEqual( expected, xml );
   }

   public void testWriteNullObjectArray() throws Exception
   {
      JSONArray jsonArray = new JSONArray( "[null,null]" );
      String expected = "<a><e class=\"object\" null=\"true\"/><e class=\"object\" null=\"true\"/></a>";
      String xml = XMLSerializer.write( jsonArray );
      assertXMLEqual( expected, xml );
   }

   public void testWriteNumberArray() throws Exception
   {
      JSONArray jsonArray = new JSONArray( "[1.1,2]" );
      String expected = "<a><e type=\"number\">1.1</e><e type=\"number\">2</e></a>";
      String xml = XMLSerializer.write( jsonArray );
      assertXMLEqual( expected, xml );
   }

   public void testWriteObject() throws Exception
   {
      JSONObject jsonObject = new JSONObject( "{\"name\":\"json\"}" );
      String expected = "<o><name type=\"string\">json</name></o>";
      String xml = XMLSerializer.write( jsonObject );
      assertXMLEqual( expected, xml );
   }

   public void testWriteObjectArray() throws Exception
   {
      JSONArray jsonArray = new JSONArray( "[{\"name\":\"json\"}]" );
      String expected = "<a><e class=\"object\"><name type=\"string\">json</name></e></a>";
      String xml = XMLSerializer.write( jsonArray );
      assertXMLEqual( expected, xml );
   }

   public void testWriteStringArray() throws Exception
   {
      JSONArray jsonArray = new JSONArray( "['1','2']" );
      String expected = "<a><e type=\"string\">1</e><e type=\"string\">2</e></a>";
      String xml = XMLSerializer.write( jsonArray );
      assertXMLEqual( expected, xml );
   }
}