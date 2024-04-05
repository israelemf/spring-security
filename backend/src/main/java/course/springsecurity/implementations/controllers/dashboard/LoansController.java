package course.springsecurity.implementations.controllers.dashboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
    @GetMapping("/loans")
    public String getLoansDetails() {
        return "Return loans details";
    }
}
