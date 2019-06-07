package io.simba.session.controller;

import io.simba.session.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SessionController {
    @GetMapping("/session")
    public String session(HttpSession httpSession, @ModelAttribute User user) {
        httpSession.setAttribute("user:" + user.getId(), user);

        return "Success.";
    }
}
