package org.itstep.helloobjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserControllerTL {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("users",userService.findAll());
        return "users";
    }

}
