package com.wiki.wikij.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * Created by Vardan Aivazian
 * Date: 3/7/2019
 * Time: 4:19 PM
 */

@Service
public class RestClientServiceImpl implements RestClientService {

    private RestTemplate rest;
    private HttpHeaders headers;
    private HttpStatus status;


    @PostConstruct
    public void init() {
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();
        this.headers.add("Content-Type", "application/json");
        this.headers.add("Accept", "*/*");
    }
    
    
    public String get(String uri) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", this.headers);
        ResponseEntity<String> responseEntity = this.rest.exchange(uri, HttpMethod.GET, requestEntity, String.class);
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    public String post(String uri, String json) {
        HttpEntity<String> requestEntity = new HttpEntity<>(json, this.headers);
        ResponseEntity<String> responseEntity = this.rest.exchange(uri, HttpMethod.POST, requestEntity, String.class);
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    @Override
    public void put(String uri, String json) {
        //not implemented
    }

    @Override
    public void delete(String uri) {
        //not implemented
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    
}
