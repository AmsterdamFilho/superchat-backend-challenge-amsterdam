package de.superchat.subdomains.messaging.application.ports.driving.channels.sms;

import de.superchat.subdomains.messaging.domain.model.channels.sms.Sms;
import io.smallrye.mutiny.Uni;

public interface SmsService {

    Uni<Void> receiveMessage(Sms sms);
}
