package org.example.client.restTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

/**
 * author: zhn4528
 * create: 2023/5/24 19:33
*/
@Repository
public class JdkRestTemplateClient {

    @Autowired
    private RestTemplate restTemplate;

    public String get(String url, Map<String, String> uriParamMap, MultiValueMap<String, String> queryParamMap) {
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParams(queryParamMap)
                .build();
        HttpEntity<String> requestEntity = new HttpEntity<>(null, null);
        ResponseEntity<String> strResponse = restTemplate.exchange(
                builder.toUriString(), HttpMethod.GET, requestEntity, String.class, uriParamMap
        );
        return strResponse.getBody();
    }

}
