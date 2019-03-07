package com.wiki.wikij.service;

import org.springframework.stereotype.Service;

/**
 * Created by Vardan Aivazian
 * Date: 3/7/2019
 * Time: 4:24 PM
 */

@Service
public class EndpointProviderServiceImpl implements EndpointProviderService {

    private static final String BASE_URI = "https://en.wikipedia.org/w/api.php?format=json&action=query";

    @Override
    public String getBase() {
        return BASE_URI;
    }
    
    @Override
    public String getPage(String title) {
        return BASE_URI + "&prop=revisions&rvprop=content&titles=" + title;
    }
    
    @Override
    public String getPages(String title) {
        return BASE_URI + "&list=search&srsearch=" + title;
    }
}
