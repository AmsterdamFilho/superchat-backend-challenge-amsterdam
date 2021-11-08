package de.superchat.subdomains.messaging.domain.model.channels.sms;

import de.superchat.subdomains.messaging.domain.model.core.Channel;
import de.superchat.subdomains.messaging.domain.model.core.ChannelName;
import de.superchat.subdomains.messaging.domain.model.core.ChannelPort;
import de.superchat.subdomains.messaging.domain.model.core.ChannelVisitor;
import de.superchat.subdomains.messaging.domain.model.messages.Message;
import de.superchat.subdomains.messaging.domain.ports.external_services.sms.SmsPort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SmsChannel extends Channel<Sms> {

    @Inject SmsAcl acl;
    @Inject SmsPort port;

    @Override
    public ChannelName name() {
        return ChannelName.SMS;
    }

    @Override
    public Sms translate(Message message) {
        return acl.translate(message);
    }

    @Override
    public ChannelPort<Sms> port() {
        return port;
    }

    @Override
    public void accept(ChannelVisitor visitor) {
        visitor.visit(this);
    }
}
