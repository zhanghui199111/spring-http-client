package org.example.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * author: zhn4528
 * create: 2023/5/24 17:28
*/
@Configuration
public class RestTemplateConfig {

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofSeconds(5))
                .setReadTimeout(Duration.ofSeconds(5))
                .build();
    }

//    @Bean
//    RestTemplate restTemplate() {
//        OkHttp3ClientHttpRequestFactory requestFactory = new OkHttp3ClientHttpRequestFactory();
//        requestFactory.setConnectTimeout(15000);
//        requestFactory.setReadTimeout(120000);
//        requestFactory.setWriteTimeout(120000);
//
//        RestTemplate template = new RestTemplate(requestFactory);
//        if (template.getMessageConverters().removeIf(MappingJackson2HttpMessageConverter.class::isInstance)) {
//            template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        }
//        return template;
//    }

}
