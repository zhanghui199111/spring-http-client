package org.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.servlet.http.HttpServletRequest;


//@TestPropertySource(locations = "classpath:application-test.yml")
@ContextConfiguration
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = HttpClientTestApplication.class)
@ActiveProfiles("test")
public class BaseTestCase {

    @Configuration
    @ComponentScan("org.example")
    public static class SpringConfig {

        @Bean
        public HttpServletRequest httpServletRequest() {
            return Mockito.mock(HttpServletRequest.class);
        }
    }
}
