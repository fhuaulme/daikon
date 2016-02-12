package org.talend.daikon.schema.type;

/**
 * Callback for code that knows how to write a specific type to a container.
 */
public interface ContainerWriter<WriteContainerT, T> {

    public void writeValue(WriteContainerT app, String key, T value);

    public void writeValue(WriteContainerT app, int index, T value);
}