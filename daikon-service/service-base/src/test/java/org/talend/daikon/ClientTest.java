package org.talend.daikon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientTest extends ServiceBaseTests {

    @Autowired
    ClientService clients;

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalServiceClass() throws Exception {
        // of(...) takes only interfaces
        clients.of(Object.class);
    }

    @Test
    public void testAutoMode() throws Exception {
        final String sayAuto1 = clients.of(TestService.class).sayHi();
        final String sayAuto2 = clients.of(TestService.class, Access.AUTO).sayHi();
        assertEquals(TestService.I_SAY_HI, sayAuto1);
        assertEquals(sayAuto1, sayAuto2);
    }

    @Test
    public void testLocalMode() throws Exception {
        final String sayLocal = clients.of(TestService.class, Access.LOCAL).sayHi();
        assertEquals(TestService.I_SAY_HI, sayLocal);
    }

    @Test
    public void testRemoteMode() throws Exception {
        final String sayRemote = clients.of(TestService.class, Access.REMOTE).sayHi();
        assertEquals(TestService.I_SAY_HI, sayRemote);
    }

}
