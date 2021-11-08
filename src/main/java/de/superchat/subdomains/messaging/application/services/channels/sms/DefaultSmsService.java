package de.superchat.subdomains.messaging.application.services.channels.sms;

import de.superchat.subdomains.messaging.application.ports.driving.channels.sms.SmsService;
import de.superchat.subdomains.messaging.domain.model.channels.sms.Sms;
import de.superchat.subdomains.messaging.domain.model.channels.sms.SmsAcl;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DefaultSmsService implements SmsService {

    @Inject SmsAcl smsAcl;

    @Override
    public Uni<Void> receiveMessage(Sms sms) {
        return smsAcl.receiveMessage(sms).replaceWithVoid();
    }
}
