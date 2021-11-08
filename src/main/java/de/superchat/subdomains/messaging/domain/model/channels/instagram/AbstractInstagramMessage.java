package de.superchat.subdomains.messaging.domain.model.channels.instagram;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.superchat.utils.DefaultStyle;
import org.immutables.value.Value;

@DefaultStyle
@Value.Immutable
@JsonSerialize(as = InstagramMessage.class)
@JsonDeserialize(as = InstagramMessage.class)
public abstract class AbstractInstagramMessage {

    abstract String contactInstagramAccount();

    abstract String content();
}
