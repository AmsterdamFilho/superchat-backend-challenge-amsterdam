package de.superchat.subdomains.messaging.domain.model.channels.sms;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.superchat.utils.DefaultStyle;
import org.immutables.value.Value;

@DefaultStyle
@Value.Immutable
@JsonSerialize(as = Sms.class)
@JsonDeserialize(as = Sms.class)
public abstract class AbstractSms {

    private static final Integer TEXT_MAX_LENGTH = 20;

    abstract String contactSmsNumber();

    abstract String text();

    @Value.Check
    public void check() {
        if (text().length() > TEXT_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("Sms maximum length is %s characters!", TEXT_MAX_LENGTH));
        }
    }
}
