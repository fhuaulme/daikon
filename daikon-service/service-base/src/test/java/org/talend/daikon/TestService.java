package org.talend.daikon;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "TestService", url = "http://127.0.0.1:8989")
public interface TestService {

    String I_SAY_HI = "I say hi!";

    @RequestMapping(value = "/path/to/service", method = RequestMethod.GET)
    String sayHi();

}
