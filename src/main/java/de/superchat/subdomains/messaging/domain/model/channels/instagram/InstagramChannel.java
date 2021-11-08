package de.superchat.subdomains.messaging.domain.model.channels.instagram;

import de.superchat.subdomains.messaging.domain.model.core.Channel;
import de.superchat.subdomains.messaging.domain.model.core.ChannelName;
import de.superchat.subdomains.messaging.domain.model.core.ChannelPort;
import de.superchat.subdomains.messaging.domain.model.core.ChannelVisitor;
import de.superchat.subdomains.messaging.domain.model.messages.Message;
import de.superchat.subdomains.messaging.domain.ports.external_services.instagram.InstagramPort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class InstagramChannel extends Channel<InstagramMessage> {

    @Inject InstagramAcl acl;
    @Inject InstagramPort port;

    @Override
    public ChannelName name() {
        return ChannelName.INSTAGRAM;
    }

    @Override
    public InstagramMessage translate(Message message) {
        return acl.translate(message);
    }

    @Override
    public ChannelPort<InstagramMessage> port() {
        return port;
    }

    @Override
    public void accept(ChannelVisitor visitor) {
        visitor.visit(this);
    }
}
