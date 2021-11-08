package de.superchat.subdomains.messaging.application.ports.driving.contacts;

import de.superchat.subdomains.messaging.domain.model.contacts.Contact;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface ContactService {

    Uni<List<Contact>> getAllContacts();

    Uni<Long> createContact(Contact contact);
}
