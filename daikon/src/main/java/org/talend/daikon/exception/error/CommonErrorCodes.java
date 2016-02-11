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
package org.talend.daikon.exception.error;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

public enum CommonErrorCodes implements ErrorCode {
    UNEXPECTED_EXCEPTION(HttpServletResponse.SC_INTERNAL_SERVER_ERROR), // 500
    MISSING_I18N_TRANSLATOR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "key", "baseName"), //$NON-NLS-1$ //$NON-NLS-2$
    UNABLE_TO_PARSE_JSON(HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
    UNABLE_TO_WRITE_JSON(HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
    UNABLE_TO_SERIALIZE_TO_JSON(HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
    UNABLE_TO_READ_CONTENT(HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
    UNABLE_TO_PARSE_REQUEST(HttpServletResponse.SC_BAD_REQUEST); // 400,
                                                                 // e.g
                                                                 // IllegalArgumentException

    /** The http status to use. */
    private int httpStatus;

    /** Expected entries to be in the context. */
    private List<String> expectedContextEntries;

    /**
     * default constructor.
     * 
     * @param httpStatus the http status to use.
     */
    CommonErrorCodes(int httpStatus) {
        this.httpStatus = httpStatus;
        this.expectedContextEntries = Collections.emptyList();
    }

    /**
     * default constructor.
     *
     * @param httpStatus the http status to use.
     */
    CommonErrorCodes(int httpStatus, String... contextEntries) {
        this.httpStatus = httpStatus;
        this.expectedContextEntries = Arrays.asList(contextEntries);
    }

    /**
     * @return the product. Default value is Talend.
     */
    @Override
    public String getProduct() {
        return "Talend"; //$NON-NLS-1$
    }

    /**
     * @return the group. Default Value is ALL
     */
    @Override
    public String getGroup() {
        return "ALL"; //$NON-NLS-1$
    }

    /**
     * @return the http status.
     */
    @Override
    public int getHttpStatus() {
        return httpStatus;
    }

    /**
     * @return the expected context entries.
     */
    @Override
    public Collection<String> getExpectedContextEntries() {
        return expectedContextEntries;
    }

    @Override
    public String getCode() {
        return this.toString();
    }
}
