package org.example;

import org.example.client.spring.SpringVerifyClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * author: zhn4528
 * create: 2023/1/4 21:33
*/
@SpringBootTest
public class HttpClientApplicationTest {

    @Autowired
    private SpringVerifyClient springVerifyClient;

    @Test
    void testDemoApi() {
        System.out.println(springVerifyClient.get("demo"));
    }

}
