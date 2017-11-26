package com.aminfo.utils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private static final String template = "Welcome to the world of Spring";

    @RequestMapping("/")
    public String index() {
    	String indexPage = "<html><h1>"+template+"</h1><br/>";
    	indexPage += "<h3>user below urls to check crud operations </h3><br/><ol>";
    	indexPage += "<li> <a>http://localhost:8080/user/create?emailId=user@aminfosystem.com&userName=User Name</a></li>";
    	indexPage += "<li> <a> http://localhost:8080/user/findAll </a></li>";
    	indexPage += "<li> <a> http://localhost:8080/user/findByEmailIdl?emailId=user@aminfosystem.com </a></li>";
    	indexPage += "<li> <a> http://localhost:8080/user/update/2?&emailId=user2@aminfosystem.com&name=user 2 </a></li>";
    	indexPage += "<li> <a> http://localhost:8080/user/delete/1 </a></li> </ol>";
    	indexPage +="</html>";
        return indexPage;
    }
}
