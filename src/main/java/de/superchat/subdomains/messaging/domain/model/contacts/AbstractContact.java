package de.superchat.subdomains.messaging.domain.model.contacts;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.superchat.subdomains.messaging.domain.model.core.Channel;
import de.superchat.subdomains.messaging.domain.model.exceptions.DomainException;
import de.superchat.subdomains.messaging.domain.ports.repositories.contacts.ContactRepository;
import de.superchat.utils.DefaultStyle;
import io.smallrye.mutiny.Uni;
import org.immutables.value.Value;

import java.util.Optional;

@DefaultStyle
@Value.Immutable
@JsonSerialize(as = Contact.class)
@JsonDeserialize(as = Contact.class)
public abstract class AbstractContact {

    abstract Optional<Long> id();

    abstract Optional<String> instagramAccount();

    abstract String name();

    abstract Optional<String> smsNumber();

    public Uni<Contact> persist(ContactRepository repository) {
        if (id().isPresent()) {
            throw new DomainException("Cannot persist a contact that already has an id! Please remove the id field first.");
        }
        return repository.persist(((Contact) this)).map(((Contact) this)::withId);
    }

    public Boolean hasChannel(Channel<?> channel) {
        ContactChannelVisitor contactChannelVisitor = new ContactChannelVisitor(this);
        channel.accept(contactChannelVisitor);
        return contactChannelVisitor.getResult();
    }
}
