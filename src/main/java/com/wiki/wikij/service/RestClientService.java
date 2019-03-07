package com.wiki.wikij.service;

import org.springframework.http.HttpStatus;

/**
 * Created by Vardan Aivazian
 * Date: 3/7/2019
 * Time: 4:19 PM
 */
public interface RestClientService {

    String get(String uri);

    String post(String uri, String json);

    void put(String uri, String json);

    void delete(String uri);

    HttpStatus getStatus();

    void setStatus(HttpStatus status);
    
}
