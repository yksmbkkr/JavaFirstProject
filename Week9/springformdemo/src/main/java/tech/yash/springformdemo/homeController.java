package tech.yash.springformdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.yash.springformdemo.pojo.Student;

import java.util.Map;

@Controller
public class homeController {

    @GetMapping({"/","/home"})
    public String home(Model model){
        ApplicationContext employeeConfig = new ClassPathXmlApplicationContext("studentConfig.xml");
        Map<String, Student> studentData = (Map<String, Student>) employeeConfig.getBean("studentMap");
        model.addAttribute("studentMap", studentData);
        return "index";
    }

}
