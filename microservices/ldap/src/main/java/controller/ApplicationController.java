package controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class ApplicationController {

    @GetMapping("/secure")
    public String secureMethod() {
        return "secure rest endpoint";
    }

    @GetMapping("/test")
    public  Integer get(){
        return 1;
    }

}
