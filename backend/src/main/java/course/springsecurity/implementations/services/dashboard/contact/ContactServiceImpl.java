package course.springsecurity.implementations.services.dashboard.contact;

import course.springsecurity.implementations.entities.Contact;
import course.springsecurity.implementations.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact saveContactRequestDetails(Contact contact) {
        contact.setContactId(generateContactRequestId());
        return contactRepository.save(contact);
    }

    private String generateContactRequestId() {
        Random random = new Random();
        int randomNumber = random.nextInt(999999999 - 9999) + 9999;
        return "SR" + randomNumber;
    }
}
