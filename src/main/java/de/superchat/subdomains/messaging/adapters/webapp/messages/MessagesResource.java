package de.superchat.subdomains.messaging.adapters.webapp.messages;

import de.superchat.subdomains.messaging.application.model.messages.GetMessageDto;
import de.superchat.subdomains.messaging.application.model.messages.PostMessageDto;
import de.superchat.subdomains.messaging.application.ports.driving.messages.MessageService;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("messages")
@Tag(name = "messages")
public class MessagesResource {

    @Inject MessageService messageService;

    @GET
    public Uni<List<GetMessageDto>> listAllConversations() {
        return messageService.listAllConversations();
    }

    @POST
    public Uni<Long> post(PostMessageDto dto) {
        return messageService.sendMessage(dto);
    }
}
