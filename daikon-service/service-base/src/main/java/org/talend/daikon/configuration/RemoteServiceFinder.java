package org.talend.daikon.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.talend.daikon.Access;
import org.talend.daikon.ServiceFinder;

/**
 * A {@link ServiceFinder} implementation that leverages Feign to create a remote client.
 */
@Component
class RemoteServiceFinder implements ServiceFinder {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public <T> T find(Class<T> serviceClass) {
        final String name = serviceClass.getAnnotation(FeignClient.class).name();
        return (T) applicationContext.getBean(name + "FeignClient");
    }

    @Override
    public boolean allow(Access access) {
        return access == Access.REMOTE;
    }
}
