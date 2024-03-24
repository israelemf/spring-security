package course.springsecurity.implementations.controllers.dashboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping("/balance")
    public String getBalanceDetails() {
        return "Return balance details";
    }
}
