package org.example.client.apache;

import com.alibaba.fastjson.JSONObject;
import org.example.BaseTestCase;
import org.example.client.apache.sync.HttpClientUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static org.example.constant.HttpConst.HTTP;

/**
 * author: zhn4528
 * create: 2023/5/23 17:24
*/
public class HttpClientTest extends BaseTestCase {

    @Autowired
    private HttpClientUtil httpClient;

    @Test
    void testHttpClient() throws IOException, URISyntaxException {
        String param = "upiopinjpkbpahdpkjfna";
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("param", param);
        JSONObject responseJSON = httpClient.get(HTTP, "127.0.0.1:8080/get", urlParams);
        System.out.println(responseJSON);
        Assertions.assertEquals(param, responseJSON.getString("body"));
    }

}
