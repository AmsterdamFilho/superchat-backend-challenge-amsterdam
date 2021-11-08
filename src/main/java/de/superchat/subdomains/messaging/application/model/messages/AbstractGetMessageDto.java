package de.superchat.subdomains.messaging.application.model.messages;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.superchat.subdomains.messaging.domain.model.contacts.Contact;
import de.superchat.subdomains.messaging.domain.model.core.ChannelName;
import de.superchat.subdomains.messaging.domain.model.messages.MessageType;
import de.superchat.utils.DefaultStyle;
import org.immutables.value.Value;

import java.util.Optional;

@DefaultStyle
@Value.Immutable
@JsonSerialize(as = GetMessageDto.class)
@JsonDeserialize(as = GetMessageDto.class)
public abstract class AbstractGetMessageDto {

    abstract Optional<Long> id();

    abstract ChannelName channel();

    abstract Contact contact();

    abstract String content();

    abstract MessageType type();
}
