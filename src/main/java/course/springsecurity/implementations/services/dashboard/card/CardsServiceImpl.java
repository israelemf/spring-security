package course.springsecurity.implementations.services.dashboard.card;

import course.springsecurity.implementations.entities.Card;
import course.springsecurity.implementations.repositories.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsServiceImpl implements CardsService {
    private final CardRepository cardRepository;

    public CardsServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> getCardsDetails(int id) {
        List<Card> cards = cardRepository.findByCustomerId(id);

        if (!cards.isEmpty()) {
            return cards;
        } else {
            return null;
        }
    }
}
