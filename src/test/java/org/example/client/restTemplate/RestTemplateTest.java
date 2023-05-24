package org.example.client.restTemplate;

import org.example.BaseTestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

/**
 * author: zhn4528
 * create: 2023/1/4 21:33
 */
public class RestTemplateTest extends BaseTestCase {

    @Autowired
    private JdkRestTemplateClient jdkRestTemplateClient;

    private final static String TEST_URL = "http://localhost:8080/get";

    @Test
    void testJdkRestTemplate() {
        String param = "afasdva23avdsfa";
        MultiValueMap<String, String> queryParamMap = new LinkedMultiValueMap<>();
        queryParamMap.add("param", param);

        String result = jdkRestTemplateClient.get(TEST_URL, new HashMap<>(), queryParamMap);
        Assertions.assertEquals(param, result);
    }

}
