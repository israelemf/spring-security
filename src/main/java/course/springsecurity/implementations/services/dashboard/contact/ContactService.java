package course.springsecurity.implementations.services.dashboard.contact;

import course.springsecurity.implementations.entities.Contact;

public interface ContactService {
    Contact saveContactRequestDetails(Contact contact);
}
