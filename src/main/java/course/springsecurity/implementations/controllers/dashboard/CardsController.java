package course.springsecurity.implementations.controllers.dashboard;

import course.springsecurity.implementations.entities.Card;
import course.springsecurity.implementations.services.dashboard.card.CardsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {
    private final CardsServiceImpl cardsService;

    @Autowired
    public CardsController(CardsServiceImpl cardsService) {
        this.cardsService = cardsService;
    }

    @GetMapping("/cards")
    public ResponseEntity<List<Card>> getCardsDetails(@RequestParam int id) {
        return ResponseEntity.ok().body(cardsService.getCardsDetails(id));
    }
}
