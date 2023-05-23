package org.example.client.apache;

import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.example.BaseTestCase;
import org.example.client.apache.async.AsyncHandlerAdapter;
import org.example.client.apache.async.AsyncHttpClientUtil;
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
public class AsyncHttpClientTest extends BaseTestCase {

    @Autowired
    private AsyncHttpClientUtil asyncHttpClient;

    @Test
    void testAsyncHttpClient() throws IOException, URISyntaxException {
        String param = "weqfqafcqsrtwergv";
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("param", param);
        asyncHttpClient.get(HTTP, "127.0.0.1:8080/get", urlParams, null,
                new AsyncHandlerAdapter() {

                    @Override
                    public Object failed(Exception e) {
                        return null;
                    }

                    @Override
                    public Object completed(HttpResponse httpResponse) {
                        JSONObject response = BaseHttpClientUtil.getJSONResponse(httpResponse);
                        if (HttpStatus.SC_OK != response.getIntValue("code")) {
                            return response;
                        }
                        Assertions.assertEquals(param, response.getString("body"));
                        return response;
                    }

                    @Override
                    public Object cancelled() {
                        return null;
                    }
                });

        try {
            Thread.sleep(1000 * 5);
        } catch (Exception e) {
            System.out.println(ExceptionUtils.getStackTrace(e));
        }

    }

}
