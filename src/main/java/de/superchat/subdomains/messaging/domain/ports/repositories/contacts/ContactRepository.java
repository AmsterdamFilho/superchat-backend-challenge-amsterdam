package de.superchat.subdomains.messaging.domain.ports.repositories.contacts;

import de.superchat.subdomains.messaging.domain.model.contacts.Contact;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface ContactRepository {

    Uni<List<Contact>> findAll();

    Uni<Contact> findById(Long id);

    Uni<Long> persist(Contact contact);

    Uni<Contact> findByInstagramAccount(String instagramAccount);

    Uni<Contact> findBySmsNumber(String smsNumber);
}
