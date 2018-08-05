package com.lovejeet.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class TilesController {
	private static final Logger log = Logger.getLogger(TilesController.class);
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String loginPage(ModelMap model) {
		log.info("hit-------------------");
        return "login";
    }
	
	@RequestMapping(value = { "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
		log.info("hit-------------------");
        return "home";
    }
 
    @RequestMapping(value = { "/products"}, method = RequestMethod.GET)
    public String productsPage(ModelMap model) {
        return "products";
    }
 
    @RequestMapping(value = { "/contactus"}, method = RequestMethod.GET)
    public String contactUsPage(ModelMap model) {
        return "contactus";
    }
}