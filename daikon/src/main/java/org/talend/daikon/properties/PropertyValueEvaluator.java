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

/**
 * This shall be implemented in order to have Properties value interpreted to the actual value if they hold some king of
 * language descriptor such as a context string, or system property value.
 */
public interface PropertyValueEvaluator {

    /**
     * compute the actual value of the given property according to the storedValue
     * 
     * @param property
     * @param storedValue value stored for this property that may be transformed.
     * @return
     */
    public Object evaluate(Property property, Object storedValue);
}
