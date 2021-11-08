package de.superchat.subdomains.messaging.adapters.external_services.instagram;

import de.superchat.infrastructure.instagram.InstagramClient;
import de.superchat.subdomains.messaging.domain.model.channels.instagram.InstagramMessage;
import de.superchat.subdomains.messaging.domain.ports.external_services.instagram.InstagramPort;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class InstagramAdapter implements InstagramPort {

    @Inject InstagramClient client;

    @Override
    public Uni<Void> sendMessage(InstagramMessage message) {
        return client.sendMessage(message.content(), message.contactInstagramAccount());
    }
}
