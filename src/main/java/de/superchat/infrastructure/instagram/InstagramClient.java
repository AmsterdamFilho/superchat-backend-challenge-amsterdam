package de.superchat.infrastructure.instagram;

import io.smallrye.mutiny.Uni;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class InstagramClient {

    @Inject Logger logger;

    public Uni<Void> sendMessage(String message, String toAccount) {
        logger.info(String.format("Sent instagram message \"%s\" to %s", message, toAccount));
        return Uni.createFrom().nullItem();
    }
}
