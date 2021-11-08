package de.superchat.subdomains.messaging.adapters.db.contacts.records;

import de.superchat.subdomains.messaging.domain.model.contacts.Contact;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Entity;
import java.util.Optional;

@Entity
public class ContactRecord extends PanacheEntity {

    public String instagramAccount;
    public String name;
    public String smsNumber;

    public Contact toDomain() {
        return Contact.builder().
                id(id).
                instagramAccount(Optional.ofNullable(instagramAccount)).
                name(name).
                smsNumber(Optional.ofNullable(smsNumber)).
                build();
    }

    public static ContactRecord fromDomain(Contact contact) {
        ContactRecord contactRecord = new ContactRecord();
        contact.id().ifPresent(id -> contactRecord.id = id);
        contact.instagramAccount().ifPresent(instagramAccount -> contactRecord.instagramAccount = instagramAccount);
        contactRecord.name = contact.name();
        contact.smsNumber().ifPresent(smsNumber -> contactRecord.smsNumber = smsNumber);
        return contactRecord;
    }
}
