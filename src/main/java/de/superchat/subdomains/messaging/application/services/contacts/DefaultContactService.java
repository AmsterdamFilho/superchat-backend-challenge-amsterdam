package de.superchat.subdomains.messaging.application.services.contacts;

import de.superchat.subdomains.messaging.domain.ports.repositories.contacts.ContactRepository;
import de.superchat.subdomains.messaging.application.ports.driving.contacts.ContactService;
import de.superchat.subdomains.messaging.domain.model.contacts.Contact;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class DefaultContactService implements ContactService {

    @Inject ContactRepository repository;

    @Override
    public Uni<List<Contact>> getAllContacts() {
        return repository.findAll();
    }

    @Override
    public Uni<Long> createContact(Contact contact) {
        return contact.persist(repository).map(persisted -> persisted.id().orElseThrow());
    }
}
