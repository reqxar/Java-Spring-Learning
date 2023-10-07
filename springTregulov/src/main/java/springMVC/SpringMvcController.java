package springMVC;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SpringMvcController {

    @RequestMapping("/")
    public String startPage(){
        return "startPage";
    }

    @RequestMapping("/askEmployeeDetails")
    public String askEmployeeDetails(Model model){

        model.addAttribute("Employee", new Employee());
        return "askEmployeeDetails";
    }

    @RequestMapping("/showEmployeeDetails")
    public String showEmployeeDetails(@Valid @ModelAttribute("Employee") Employee employee,
                                      BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "askEmployeeDetails";
        }else {
            return "showEmployeeDetails";
        }
    }

}
