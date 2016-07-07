package org.talend.daikon;

/**
 * Indicate the way an API is accessed. Depending on available resources,
 * @see org.talend.daikon.ClientService
 */
public enum Access {
    /**
     * Finds the service inside the available Spring beans.
     */
    LOCAL,
    /**
     * Finds the service using an HTTP communication.
     */
    REMOTE,
    /**
     * First tries {@link #LOCAL} then {@link #REMOTE}.
     */
    AUTO
}
