package org.talend.daikon;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TestServiceImpl implements TestService {

    @Override
    @RequestMapping(value = "/path/to/service", method = RequestMethod.GET)
    public String sayHi() {
        return I_SAY_HI;
    }
}
