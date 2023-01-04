package org.example.client.spring;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * author: zhn4528
 * create: 2023/1/4 21:30
*/
@HttpExchange
public interface SpringVerifyClient {

    @GetExchange("/get")
    String get(@RequestParam(value = "param") String param);

}
