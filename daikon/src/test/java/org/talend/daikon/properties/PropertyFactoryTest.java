// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.daikon.properties;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.talend.daikon.schema.SchemaElement;
import org.talend.daikon.schema.SchemaElement.Type;

/**
 * created by pbailly on 4 Dec 2015 Detailled comment
 *
 */
public class PropertyFactoryTest {

    @Test
    public void testNewProperty() {
        SchemaElement element = PropertyFactory.newProperty("testProperty");
        assertEquals("testProperty", element.getName());
        assertNull(element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.STRING, element.getType());
    }

    @Test
    public void testNewProperty_WithTtitle() {
        SchemaElement element = PropertyFactory.newProperty("testProperty", "title");
        assertEquals("testProperty", element.getName());
        assertNull(element.getDefaultValue());
        assertEquals("title", element.getTitle());
        assertEquals(Type.STRING, element.getType());

    }

    @Test
    public void testNewProperty_WithTypeAndTitle() {
        SchemaElement element = PropertyFactory.newProperty(Type.BOOLEAN, "testProperty", "title");
        assertEquals("testProperty", element.getName());
        assertNull(element.getDefaultValue());
        assertEquals("title", element.getTitle());
        assertEquals(Type.BOOLEAN, element.getType());
    }

    @Test
    public void testNewProperty_WithType() {
        SchemaElement element = PropertyFactory.newProperty(Type.BOOLEAN, "testProperty");
        assertEquals("testProperty", element.getName());
        assertNull(element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.BOOLEAN, element.getType());
    }

    @Test
    public void testNewString() {
        SchemaElement element = PropertyFactory.newString("testProperty");
        assertEquals("testProperty", element.getName());
        assertNull(element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.STRING, element.getType());
    }

    @Test
    public void testNewInteger() {
        SchemaElement element = PropertyFactory.newInteger("testProperty");
        assertEquals("testProperty", element.getName());
        assertNull(element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.INT, element.getType());
    }

    @Test
    public void testNewInteger_defaultvalueString() {
        SchemaElement element = PropertyFactory.newInteger("testProperty", "10");
        assertEquals("testProperty", element.getName());
        assertEquals("10", element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.INT, element.getType());
    }

    @Test
    public void testNewInteger_defaultvalueInteger() {
        SchemaElement element = PropertyFactory.newInteger("testProperty", 10);
        assertEquals("testProperty", element.getName());
        assertEquals("10", element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.INT, element.getType());
    }

    @Test
    public void testNewFloat() {
        SchemaElement element = PropertyFactory.newFloat("testProperty");
        assertEquals("testProperty", element.getName());
        assertNull(element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.FLOAT, element.getType());
    }

    @Test
    public void testNewFloat_defaultvalue() {
        SchemaElement element = PropertyFactory.newFloat("testProperty", 5f);
        assertEquals("testProperty", element.getName());
        assertEquals("5.0", element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.FLOAT, element.getType());
    }

    @Test
    public void testNewFloat_StringDefaultvalue() {
        SchemaElement element = PropertyFactory.newFloat("testProperty", "5f");
        assertEquals("testProperty", element.getName());
        assertEquals("5f", element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.FLOAT, element.getType());
    }

    @Test
    public void testNewDouble() {
        SchemaElement element = PropertyFactory.newDouble("testProperty");
        assertEquals("testProperty", element.getName());
        assertNull(element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.DOUBLE, element.getType());
    }

    @Test
    public void testNewDouble_defaultvalue() {
        SchemaElement element = PropertyFactory.newDouble("testProperty", 5d);
        assertEquals("testProperty", element.getName());
        assertEquals("5.0", element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.DOUBLE, element.getType());
    }

    @Test
    public void testNewDouble_StringDefaultvalue() {
        SchemaElement element = PropertyFactory.newDouble("testProperty", "5f");
        assertEquals("testProperty", element.getName());
        assertEquals("5f", element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.DOUBLE, element.getType());
    }

    @Test
    public void testNewBoolean() {
        SchemaElement element = PropertyFactory.newBoolean("testProperty");
        assertEquals("testProperty", element.getName());
        assertNull(element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.BOOLEAN, element.getType());
    }

    @Test
    public void testNewBoolean_withDefault() {
        SchemaElement element = PropertyFactory.newBoolean("testProperty", true);
        assertEquals("testProperty", element.getName());
        assertEquals("true", element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.BOOLEAN, element.getType());
        element = PropertyFactory.newBoolean("testProperty", false);
        assertEquals("testProperty", element.getName());
        assertEquals("false", element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.BOOLEAN, element.getType());

    }

    @Test
    public void testNewBoolean_withStringDefault() {
        SchemaElement element = PropertyFactory.newBoolean("testProperty", "true");
        assertEquals("testProperty", element.getName());
        assertEquals("true", element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.BOOLEAN, element.getType());
        element = PropertyFactory.newBoolean("testProperty", "false");
        assertEquals("testProperty", element.getName());
        assertEquals("false", element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.BOOLEAN, element.getType());
    }

    @Test
    public void testNewDate() {
        SchemaElement element = PropertyFactory.newDate("testProperty");
        assertEquals("testProperty", element.getName());
        assertNull(element.getDefaultValue());
        assertNull(element.getTitle());
        assertEquals(Type.DATE, element.getType());
    }

    @Test
    public void testNewEnumString() {
        SchemaElement element = PropertyFactory.newEnum("testProperty");
        assertEquals("testProperty", element.getName());
        assertNull(element.getPossibleValues());
        assertNull(element.getTitle());
        assertEquals(Type.ENUM, element.getType());
    }

    /**
     * Test method for {@link org.talend.daikon.schema.PropertyFactory#newEnum(java.lang.String, java.lang.Object[])}.
     */
    @Test
    public void testNewEnum_withvalue() {
        SchemaElement element = PropertyFactory.newEnum("testProperty", "value1", "value2", "value3");
        assertEquals("testProperty", element.getName());
        assertNull(element.getDefaultValue());
        assertEquals(Arrays.asList("value1", "value2", "value3"), element.getPossibleValues());
        assertNull(element.getTitle());
        assertEquals(Type.ENUM, element.getType());
    }

}
