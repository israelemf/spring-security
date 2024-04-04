package course.springsecurity.implementations.services.dashboard.card;

import course.springsecurity.implementations.entities.Card;

import java.util.List;

public interface CardsService {
    List<Card> getCardsDetails(int id);
}
