package de.superchat.infrastructure.sms;

import io.smallrye.mutiny.Uni;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SmsClient {

    @Inject Logger logger;

    public Uni<Void> sendMessage(String message, String toNumber) {
        logger.info(String.format("Sent sms \"%s\" to %s", message, toNumber));
        return Uni.createFrom().nullItem();
    }
}
