package cycleSpring.cycleAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/register")
public class RegistrationController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public String getRegistrationForm(Model model) {
        if (!model.containsAttribute("userForm")) {
            model.addAttribute("userForm", new UserForm());
        }
        return "register";
    }

    @PostMapping
    public String register(@RequestBody UserForm userForm
//    BindingResult bindingResult, 
//    RedirectAttributes attr
    ) {
//        if (bindingResult.hasErrors()) {
//            attr.addFlashAttribute("org.springframework.validation.BindingResult.userForm", bindingResult);
//            attr.addFlashAttribute("userForm", userForm);
//            return "redirect:/register";
//        }
//        if (!userForm.getPassword().equals(userForm.getPasswordRepeat())) {
//            attr.addFlashAttribute("message", "Passwords must match");
//            attr.addFlashAttribute("userForm", userForm);
//            return "redirect:/register";
//        }
        User userToCreate = new User();
        userToCreate.setName(userForm.getName());
        userToCreate.setPassword(userForm.getPassword());
        System.out.println(userForm.getName() + "" + userForm.getPassword() + userForm.getPasswordRepeat());
        userService.create(userToCreate);
//        attr.addFlashAttribute("result", "Registration success!");
        return "redirect:/loginpage";
    }

}