package de.superchat.subdomains.messaging.application.ports.driving.channels.instagram;

import de.superchat.subdomains.messaging.domain.model.channels.instagram.InstagramMessage;
import io.smallrye.mutiny.Uni;

public interface InstagramService {

    Uni<Void> receiveMessage(InstagramMessage message);
}
