package com.gyt.demomodel.controller;

import com.gyt.demomodel.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

/**
 * @author gaoyituo
 * @since 2024/1/31
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    @GetMapping({"/toLogin", "/", ""})
    public String toLogin() {
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(UserDTO user) {
        if (user == null) {
            throw new RuntimeException("请求参数错误");
        }
        String username = user.getUsername();
        String password = user.getPassword();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new RuntimeException("账号和用户名不能为空！");
        }
        if ("admin".equals(username) && "abcd".equals(password)) {
            return "index";
        } else {
            return "login";
        }
    }
}
