package course.springsecurity.implementations.controllers.dashboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    @GetMapping("/cards")
    public String getCardsDetails() {
        return "Return cards details";
    }
}
