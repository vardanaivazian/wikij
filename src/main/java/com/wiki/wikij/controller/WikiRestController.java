package com.wiki.wikij.controller;

import com.wiki.wikij.service.WikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vardan Aivazian
 * Date: 3/7/2019
 * Time: 3:47 PM
 */

@RestController
public class WikiRestController {

    private final WikiService wikiService;

    @Autowired
    public WikiRestController(WikiService wikiService) {
        this.wikiService = wikiService;
    }

    
    
    @GetMapping(value = "/pages/{query}", produces = "application/json;UTF-8")
    public String pages(@PathVariable String query) {
        return wikiService.getPages(query);
    }
    
    
    @GetMapping(value = "/page/{query}", produces = "application/json;UTF-8")
    public String page(@PathVariable String query) {
        return wikiService.getPage(query);
    }
    
    
}
