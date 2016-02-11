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
package org.talend.daikon.i18n;

import static org.junit.Assert.*;

import java.util.Locale;
import java.util.MissingResourceException;

import org.junit.Test;

/**
 * created by sgandon on 11 sept. 2015
 */
public class I18nMessagesTest {

    /**
     * created by sgandon on 16 nov. 2015
     */
    private final class DynamicLocalFormatedI18nImpl extends I18nMessages {

        private String baseName;

        /**
         * DOC sgandon DynamicLocalFormatediI18n constructor comment.
         * 
         * @param localeProvider
         */
        private DynamicLocalFormatedI18nImpl(LocaleProvider localeProvider, String baseName) {
            super(localeProvider);
            this.baseName = baseName;
        }

        @Override
        public String getMessage(String key, Object... arguments) {
            return getFormattedMessage(key, this.getClass().getClassLoader(), baseName, arguments);
        }
    }

    class MutableLocalProvider implements LocaleProvider {

        Locale locale;

        @Override
        public Locale getLocale() {
            return locale;
        }

        public void setLocale(String language) {
            locale = new Locale(language);
        }
    }

    /**
     * Test method for {@link org.talend.daikon.i18n.I18nMessages#getMessage(java.lang.String, java.lang.Object[])}.
     */
    @Test
    public void testGetMessageAllDefaultStringFormat() {
        I18nMessages i18nMessages = new DynamicLocalFormatedI18nImpl(null, "org.talend.daikon.i18n.testMessage");
        assertEquals("", i18nMessages.getMessage("ze.empty.key", null));
        assertEquals("normal", i18nMessages.getMessage("ze.normal.key", null));
        assertEquals("normal", i18nMessages.getMessage("ze.normal.key", "foo"));
        assertEquals("test {0} and {1}", i18nMessages.getMessage("ze.message.key", null));
        assertEquals("test foo and bar", i18nMessages.getMessage("ze.message.key", "foo", "bar"));
    }

    @Test(expected = MissingResourceException.class)
    public void testResourceNotfoundExceptionNoKey() {
        I18nMessages i18nMessages = new DynamicLocalFormatedI18nImpl(null, "org.talend.daikon.i18n.testMessage");
        i18nMessages.getMessage("unknown.key", null);
    }

    @Test(expected = MissingResourceException.class)
    public void testResourceNotfoundExceptionNoFileFound() {
        I18nMessages i18nMessages = new DynamicLocalFormatedI18nImpl(null, "org.talend.daikon.i18n.testMessageNoExisting");
        i18nMessages.getMessage("any.key", null);
    }

    /**
     * Test method for {@link org.talend.daikon.i18n.I18nMessages#getMessage(java.lang.String, java.lang.Object[])}.
     */
    @Test
    public void testGetMessageMutableLocalProvider() {
        MutableLocalProvider mutableLocaleProvider = new MutableLocalProvider();
        I18nMessages i18nMessages = new DynamicLocalFormatedI18nImpl(mutableLocaleProvider, "org.talend.daikon.i18n.testMessage"); //$NON-NLS-1$
        // first test with a null local which shall result in the default locale
        assertEquals("", i18nMessages.getMessage("ze.empty.key", null));
        assertEquals("normal", i18nMessages.getMessage("ze.normal.key", null));
        assertEquals("normal", i18nMessages.getMessage("ze.normal.key", "foo"));
        assertEquals("test {0} and {1}", i18nMessages.getMessage("ze.message.key", null));
        assertEquals("test foo and bar", i18nMessages.getMessage("ze.message.key", "foo", "bar"));

        // set another locale
        mutableLocaleProvider.setLocale("ru"); //$NON-NLS-1$
        assertEquals("", i18nMessages.getMessage("ze.empty.key", null));
        assertEquals("norrrrmal", i18nMessages.getMessage("ze.normal.key", null));
        assertEquals("test foo and bar in russian", i18nMessages.getMessage("ze.message.key", "foo", "bar"));

    }

}
