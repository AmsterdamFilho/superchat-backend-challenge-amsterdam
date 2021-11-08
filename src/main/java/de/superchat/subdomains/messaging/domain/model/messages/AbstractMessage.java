package de.superchat.subdomains.messaging.domain.model.messages;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.superchat.subdomains.messaging.domain.model.contacts.Contact;
import de.superchat.subdomains.messaging.domain.model.core.Channel;
import de.superchat.subdomains.messaging.domain.model.exceptions.DomainException;
import de.superchat.subdomains.messaging.domain.ports.repositories.messages.MessageRepository;
import de.superchat.subdomains.messaging.domain.services.PlaceholderService;
import de.superchat.utils.DefaultStyle;
import io.smallrye.mutiny.Uni;
import org.immutables.value.Value;

import java.util.Optional;

@DefaultStyle
@Value.Immutable
@JsonSerialize(as = Message.class)
@JsonDeserialize(as = Message.class)
public abstract class AbstractMessage {

    abstract Optional<Long> id();

    abstract Channel<?> channel();

    abstract Contact contact();

    abstract String content();

    abstract MessageType type();

    @Value.Check
    public void check() {
        if (!contact().hasChannel(channel())) {
            throw new DomainException("The contact data for this channel have not been informed!");
        }
    }

    public Uni<Message> send(MessageRepository repository, PlaceholderService placeholderService) {
        if (id().isPresent()) {
            return Uni.createFrom().failure(new DomainException("Message has already been sent!"));
        }
        if (!type().equals(MessageType.OUTGOING)) {
            String message = String.format("Only messages with type %s can be sent!", MessageType.OUTGOING);
            return Uni.createFrom().failure(new DomainException(message));
        }
        Message message = (Message) this;
        return placeholderService.execute((Message) this).
                map(message::withContent).
                flatMap(channel()::send).
                flatMap(unused -> persist(repository));
    }

    public Uni<Message> persist(MessageRepository repository) {
        Message message = (Message) this;
        return repository.persist(message).
                map(message::withId);
    }
}
