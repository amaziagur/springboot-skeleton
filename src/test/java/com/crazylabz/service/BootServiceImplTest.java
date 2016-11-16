package com.crazylabz.service;

import com.crazylabz.entities.MessageResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BootServiceImplTest {

    private static final String GREET_MESSAGE = "%s, you are in test mode now";
    public static final String NAME = "little_bob";
    private BootServiceImpl booter = new BootServiceImpl();

    @Before
    public void init(){
        booter.setGreetMessage(GREET_MESSAGE);
    }

    @Test
    public void booterShouldGreetPersonalyGivenName(){
        MessageResponse messageResponse = booter.helloBoot(NAME);
        assertTrue(messageResponse.getMessage().equals(NAME + ", you are in test mode now"));
    }

    @Test
    public void booterShouldGreetGenerallyWhenGivenNoName(){
        MessageResponse messageResponse = booter.helloBoot(null);
        assertTrue(messageResponse.getMessage().equals("new friend, you are in test mode now"));
    }

}