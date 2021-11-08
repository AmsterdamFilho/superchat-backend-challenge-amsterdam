package de.superchat.subdomains.messaging.adapters.webapp.webhooks.sms;

import de.superchat.subdomains.messaging.application.ports.driving.channels.sms.SmsService;
import de.superchat.subdomains.messaging.domain.model.channels.sms.Sms;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Tag(name = "webhooks")
@Path("webhooks/sms")
public class SmsWebhook {

    @Inject SmsService service;

    @POST
    public Uni<Void> post(Sms sms) {
        return service.receiveMessage(sms);
    }
}
