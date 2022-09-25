package com.example.springb.controller;


import com.example.springb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/new")
    public String member(){
        return "user/user";
    }

    @GetMapping("/userList")
    public String userList(Model model){
        model.addAttribute("uNum", userService.userNum());
        model.addAttribute("uList", userService.userList());
        return "user/list";
    }

}
