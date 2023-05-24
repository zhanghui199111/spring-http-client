package org.example.client.restTemplate;

import org.example.BaseTestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * author: zhn4528
 * create: 2023/1/4 21:33
 */
public class RestTemplateTest extends BaseTestCase {

    @Autowired
    private RestTemplate restTemplate;

    private final static String TEST_URL = "http://localhost:8080/get";

    @Test
    void testJdkRestTemplate() {
        String param = "afasdva23avdsfa";
        Map<String, String> uriParam = new HashMap<>();

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(TEST_URL)
                .queryParam("param", param)
                .build();

        HttpEntity<String> requestEntity = new HttpEntity<>(null, null);

        ResponseEntity<String> strResponse = restTemplate.exchange(
                builder.toUriString(), HttpMethod.GET, requestEntity, String.class, uriParam
        );
        String result = strResponse.getBody();
        Assertions.assertEquals(param, result);
    }

}
