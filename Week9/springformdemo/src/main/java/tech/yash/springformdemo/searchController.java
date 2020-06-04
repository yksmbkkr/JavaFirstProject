package tech.yash.springformdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tech.yash.springformdemo.pojo.Student;

import java.util.Iterator;
import java.util.Map;

@Controller
public class searchController {

    @RequestMapping(value = "/search-student", method = RequestMethod.POST)
    public String searchStudent(@RequestParam("id") String searchID, Model model){

        int search_ID = Integer.parseInt(searchID);

        ApplicationContext employeeConfig = new ClassPathXmlApplicationContext("studentConfig.xml");
        Map<String, Student> studentData = (Map<String, Student>) employeeConfig.getBean("studentMap");

        model.addAttribute("sid",searchID);
        Iterator studenti = studentData.values().iterator();
        while(studenti.hasNext()) {
             Student temp = (Student) studenti.next();
            if (temp.equals(search_ID)) {
                model.addAttribute("resStudent",temp);
                model.addAttribute("found",true);
                break;
            }
            else if (!studenti.hasNext()) {
                model.addAttribute("found",false);

            }
        }
        return "result";
    }

}
