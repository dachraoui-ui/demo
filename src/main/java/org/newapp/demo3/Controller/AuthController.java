package org.newapp.demo3.Controller;

import jakarta.validation.Valid;
import org.newapp.demo3.DTO.RegistrationDTO;
import org.newapp.demo3.Model.UserEntity;
import org.newapp.demo3.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("/register")
    public String getRegistrationForm(Model model){
        RegistrationDTO user = new RegistrationDTO();
        model.addAttribute("user",user);
        return "register";
    }
    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDTO user ,
                           BindingResult result , Model model)
    {
        UserEntity existingUserEmail = userService.FindByEmail(user.getEmail());
        if (existingUserEmail != null && existingUserEmail.getEmail()!=null && !existingUserEmail.getEmail().isEmpty()){
            result.rejectValue("email","the username/email is already used");
        }
        UserEntity existingUsername = userService.findByUsername(user.getUsername());
        if (existingUsername != null && existingUsername.getUsername()!=null && !existingUsername.getUsername().isEmpty()){
            result.rejectValue("email","the username/email is already used");
        }
        if (result.hasErrors()){
            model.addAttribute("user",user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/club?success";
    }

}
