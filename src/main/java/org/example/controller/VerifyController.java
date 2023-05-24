package org.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: zhn4528
 * create: 2023/1/4 21:27
*/
@RestController
public class VerifyController {

    @RequestMapping("/get")
    public String get(
            @RequestParam(value = "param", required = true) String param
    ) {
        System.out.println("request happen!");
        return param;
    }

}
