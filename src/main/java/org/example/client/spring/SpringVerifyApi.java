package org.example.client.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * author: zhn4528
 * create: 2023/1/4 21:38
*/
@Configuration
public class SpringVerifyApi {

    @Bean
    SpringVerifyClient demoApi() {
        WebClient client = WebClient.builder().baseUrl("http://localhost:8080/").build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(SpringVerifyClient.class);
    }

}
