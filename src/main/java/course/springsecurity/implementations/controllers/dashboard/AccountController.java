package course.springsecurity.implementations.controllers.dashboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @GetMapping("/account")
    public String getAccountDetails() {
        return "Return account details";
    }
}
