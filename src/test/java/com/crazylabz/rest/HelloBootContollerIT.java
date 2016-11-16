package com.crazylabz.rest;

import test.com.crazylabz.config.ControlTestContext;
import test.com.crazylabz.config.TestWebConfig;
import com.crazylabz.service.BootService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SuppressWarnings("SpringJavaAutowiredMembersInspection")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {TestWebConfig.class, ControlTestContext.class})
@WebAppConfiguration
public class HelloBootContollerIT {

    private static final String NAME = "little_bob";
    private static final String BOOTER_PATH = "/hello-boot/";

    @Autowired
    private WebApplicationContext ctx;

    @Autowired
    private BootService bootService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(ctx).build();
    }

    @Test
    public void shouldGreetNewMember() throws Exception {
        mockMvc.perform(get(BOOTER_PATH + NAME)).andExpect(status().isOk());
        verify(bootService).helloBoot(NAME);
    }

}