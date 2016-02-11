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
 * Contains the result of the validation of a components property.
 * <p/>
 * This is to be returned from the {@code validate} methods in {@link Properties}.
 */
public class ValidationResult {

    public enum Result {
        OK,
        WARNING,
        ERROR
    }

    public static ValidationResult OK = new ValidationResult().setStatus(Result.OK);

    public Result status = Result.OK;

    public int number;

    public Result getStatus() {
        return status;
    }

    public ValidationResult setStatus(Result status) {
        this.status = status;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String message;

    @Override
    public String toString() {
        return getStatus() + " " + getMessage();
    }

}
