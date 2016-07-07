package org.talend.daikon;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.talend.daikon.configuration.ClientServiceConfiguration;

@Service
public class ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

    @Autowired(required = false)
    private ClientServiceConfiguration configuration = new ClientServiceConfiguration();

    /**
     * Returns a client to access <code>serviceClass</code> in specified {@link Access#AUTO} mode.
     * @param serviceClass The service class to serve as base for the returned client. Service class must be an interface.
     * @param <T> Generic type parameter to prevent cast in caller.
     * @return An instance of service class (T) ready for immediate use.
     * @see #of(Class, Access)
     */
    public <T> T of(Class<T> serviceClass) {
        return of(serviceClass, Access.AUTO);
    }

    /**
     * Returns a client to access <code>serviceClass</code> in the specified {@link Access access mode}. This method allow
     * user to specify its access mode.
     * @param serviceClass The service class to serve as base for the returned client. Service class must be an interface.
     * @param access The access mode to the service (local, remote...).
     * @param <T> Generic type parameter to prevent cast in caller.
     * @return An instance of service class (T) ready for immediate use.
     */
    public <T> T of(Class<T> serviceClass, Access access) {
        if (!serviceClass.isInterface()) {
            throw new IllegalArgumentException("Service class must be an interface.");
        }
        final List<ServiceFinder> finders = configuration.getFinders(access);
        for (ServiceFinder finder : finders) {
            LOGGER.debug("Trying finder {} for {}...", finder.getClass(), serviceClass);
            final T t = finder.find(serviceClass);
            if (t != null) {
                LOGGER.debug("Finder match for {}", serviceClass);
                return t;
            } else {
                LOGGER.debug("Finder no-match for {}", serviceClass);
            }
        }
        throw new IllegalArgumentException("Service '" + serviceClass + "' cannot be found.");
    }
}
