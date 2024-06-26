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

package net.sf.json;

/**
 * @author Andres Almiray <a href="mailto:aalmiray@users.sourceforge.net">aalmiray@users.sourceforge.net</a>
 */
public class TestJSONObjectStaticBuilders_JSONObject extends AbstractJSONObjectStaticBuildersTestCase {
    public static void main(String[] args) {
        junit.textui.TestRunner.run(TestJSONObjectStaticBuilders_JSONObject.class);
    }

    public TestJSONObjectStaticBuilders_JSONObject(String name) {
        super(name);
    }

    @Override
    protected Object getSource() {
        String[] props = getProperties();
        JSONObject jsonObject = new JSONObject();
        try {
            for (int i = 0; i < props.length; i++) {
                jsonObject.element(props[i], PropertyConstants.getPropertyValue(props[i]));
            }
            jsonObject.element("pexcluded", "");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return jsonObject;
    }
}
