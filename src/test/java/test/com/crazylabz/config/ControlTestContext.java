package test.com.crazylabz.config;

import com.crazylabz.service.BootService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.mockito.Mockito.mock;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.crazylabz.rest"})
public class ControlTestContext {

    @Bean
    public BootService getBootService() {
        return mock(BootService.class);
    }

}
