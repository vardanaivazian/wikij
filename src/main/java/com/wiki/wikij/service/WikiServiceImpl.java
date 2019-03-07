package com.wiki.wikij.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Vardan Aivazian
 * Date: 3/7/2019
 * Time: 3:50 PM
 */

@Service
public class WikiServiceImpl implements WikiService {
    
    private final
    EndpointProviderService endpointProviderService;
    
    private final
    RestClientService restClientService;

    @Autowired
    public WikiServiceImpl(EndpointProviderService endpointProviderService, RestClientService restClientService) {
        this.endpointProviderService = endpointProviderService;
        this.restClientService = restClientService;
    }

    @Override
    public String getPages(String title) {
        String uri = endpointProviderService.getPages(title);
        return restClientService.get(uri);
    }

    @Override
    public String getPage(String title) {
        String uri = endpointProviderService.getPage(title);
        return restClientService.get(uri);
    }
}
