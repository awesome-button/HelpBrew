package se.kth.sda.tech.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.kth.sda.tech.auth.AuthService;

@RestController
public class TestController {
    @Autowired
    AuthService authService;

    @GetMapping("/test")
    public String foo() {
        return authService.getLoggedInUserEmail();
    }
}
