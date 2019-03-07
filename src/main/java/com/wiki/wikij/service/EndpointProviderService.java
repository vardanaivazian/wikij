package com.wiki.wikij.service;

/**
 * Created by Vardan Aivazian
 * Date: 3/7/2019
 * Time: 4:23 PM
 */
public interface EndpointProviderService {
    
    String getBase();

    String getPages(String title);

    String getPage(String title);
}
