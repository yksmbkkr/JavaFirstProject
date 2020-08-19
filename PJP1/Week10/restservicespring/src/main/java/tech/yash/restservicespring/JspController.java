package tech.yash.restservicespring;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspController {

    @GetMapping(name = "HomePage", value = {"/", "/home"})
    public String welcome(){
        return "welcome";
    }

}
