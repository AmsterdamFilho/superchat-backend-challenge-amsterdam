package de.superchat.subdomains.messaging.application.services.channels.instagram;

import de.superchat.subdomains.messaging.application.ports.driving.channels.instagram.InstagramService;
import de.superchat.subdomains.messaging.domain.model.channels.instagram.InstagramAcl;
import de.superchat.subdomains.messaging.domain.model.channels.instagram.InstagramMessage;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DefaultInstagramService implements InstagramService {

    @Inject InstagramAcl instagramAcl;

    @Override
    public Uni<Void> receiveMessage(InstagramMessage message) {
        return instagramAcl.receiveMessage(message).replaceWithVoid();
    }
}
