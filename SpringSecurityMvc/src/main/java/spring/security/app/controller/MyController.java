package spring.security.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @GetMapping("/")
    public String infoForAll(){
        return "infoForAll";
    }
    @GetMapping("/hr-info")
    public String infoOnlyForHR(){
        return "infoOnlyForHR";
    }
    @GetMapping("manager-info")
    public String infoOnlyForMANAGER(){
        return "infoOnlyForMANAGER";
    }
}
