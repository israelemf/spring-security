package course.springsecurity.implementations.controllers.dashboard;

import course.springsecurity.implementations.entities.Contact;
import course.springsecurity.implementations.services.dashboard.contact.ContactServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactServiceImpl contactService;

    public ContactController(ContactServiceImpl contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<Contact> saveContactRequestDetails(@RequestBody Contact contact) {
        return ResponseEntity.ok().body(contactService.saveContactRequestDetails(contact));
    }
}
