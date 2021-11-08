package de.superchat.subdomains.messaging.adapters.webapp.webhooks.instagram;

import de.superchat.subdomains.messaging.application.ports.driving.channels.instagram.InstagramService;
import de.superchat.subdomains.messaging.domain.model.channels.instagram.InstagramMessage;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Tag(name = "webhooks")
@Path("webhooks/instagram")
public class InstagramWebhook {

    @Inject InstagramService service;

    @POST
    public Uni<Void> post(InstagramMessage instagramMessage) {
        return service.receiveMessage(instagramMessage);
    }
}
