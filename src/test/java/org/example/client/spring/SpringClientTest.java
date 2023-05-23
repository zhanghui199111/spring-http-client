package org.example.client.spring;

import org.example.BaseTestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * author: zhn4528
 * create: 2023/1/4 21:33
*/
public class SpringClientTest extends BaseTestCase {

    @Autowired
    private SpringVerifyClient springVerifyClient;

    @Test
    void testDemoApi() {
        String param = "afasdva23avdsfa";
        String result = springVerifyClient.get(param);
        Assertions.assertEquals(param, result);
    }

}
