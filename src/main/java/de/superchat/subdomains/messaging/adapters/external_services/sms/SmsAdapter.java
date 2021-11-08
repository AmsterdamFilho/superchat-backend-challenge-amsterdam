package de.superchat.subdomains.messaging.adapters.external_services.sms;

import de.superchat.infrastructure.sms.SmsClient;
import de.superchat.subdomains.messaging.domain.model.channels.sms.Sms;
import de.superchat.subdomains.messaging.domain.ports.external_services.sms.SmsPort;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SmsAdapter implements SmsPort {

    @Inject SmsClient smsClient;

    @Override
    public Uni<Void> sendMessage(Sms message) {
        return smsClient.sendMessage(message.text(), message.contactSmsNumber());
    }
}
