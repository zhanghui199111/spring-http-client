package org.example.config;

import org.example.client.apache.sync.HttpClientUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author: zhn4528
 * create: 2023/5/23 17:22
*/
@Configuration
public class HttpClientConfig {

    @Bean(name = "httpClient")
    public HttpClientUtil getHttpClient() {
        return new HttpClientUtil(30000, 30000, 30000, 50);
    }

}
