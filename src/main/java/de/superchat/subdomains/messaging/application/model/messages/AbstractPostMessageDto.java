package de.superchat.subdomains.messaging.application.model.messages;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.superchat.subdomains.messaging.domain.model.core.ChannelName;
import de.superchat.utils.DefaultStyle;
import org.immutables.value.Value;

@DefaultStyle
@Value.Immutable
@JsonSerialize(as = PostMessageDto.class)
@JsonDeserialize(as = PostMessageDto.class)
public abstract class AbstractPostMessageDto {

    abstract ChannelName channel();

    abstract Long contactId();

    abstract String messageContent();
}
