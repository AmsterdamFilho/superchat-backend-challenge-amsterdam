package de.superchat.subdomains.messaging.adapters.db.contacts.repository;

import de.superchat.subdomains.messaging.adapters.db.contacts.records.ContactRecord;
import de.superchat.subdomains.messaging.domain.model.exceptions.DomainException;
import de.superchat.subdomains.messaging.domain.ports.repositories.contacts.ContactRepository;
import de.superchat.subdomains.messaging.domain.model.contacts.Contact;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PanacheContactRepository implements ContactRepository {

    @Override
    public Uni<List<Contact>> findAll() {
        return ContactRecord.<ContactRecord>listAll().
                onItem().
                transformToMulti(Multi.createFrom()::iterable).
                map(ContactRecord::toDomain).
                collect().
                asList();
    }

    @Override
    public Uni<Contact> findById(Long id) {
        return ContactRecord.
                <ContactRecord>findById(id).
                onItem().
                ifNull().
                failWith(new DomainException(String.format("Contact with id %s not found!", id))).
                map(ContactRecord::toDomain);
    }

    @Override
    @ReactiveTransactional
    public Uni<Long> persist(Contact contact) {
        return ContactRecord.fromDomain(contact).
                <ContactRecord>persistAndFlush().
                map(contactRecord -> contactRecord.id);
    }

    @Override
    public Uni<Contact> findByInstagramAccount(String instagramAccount) {
        return ContactRecord.
                <ContactRecord>find("instagramAccount", instagramAccount).
                firstResult().
                onItem().
                ifNull().
                failWith(new DomainException("Instagram account not found!")).
                map(ContactRecord::toDomain);
    }

    @Override
    public Uni<Contact> findBySmsNumber(String smsNumber) {
        return ContactRecord.
                <ContactRecord>find("smsNumber", smsNumber).
                firstResult().
                onItem().
                ifNull().
                failWith(new DomainException("Sms number not found!")).
                map(ContactRecord::toDomain);
    }
}
