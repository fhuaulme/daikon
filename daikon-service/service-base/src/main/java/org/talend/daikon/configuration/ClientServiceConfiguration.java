package org.talend.daikon.configuration;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.talend.daikon.Access;
import org.talend.daikon.ServiceFinder;

@Configuration
public class ClientServiceConfiguration {

    @Autowired(required = false)
    private List<ServiceFinder> finders;

    public List<ServiceFinder> getFinders(Access access) {
        if (access == Access.LOCAL || access == Access.REMOTE) {
            return finders.stream().filter(f -> f.allow(access)).collect(Collectors.toList());
        } else if (access == Access.AUTO) {
            return finders;
        } else {
            throw new IllegalArgumentException("Unsupported mode: " + access);
        }
    }

}
