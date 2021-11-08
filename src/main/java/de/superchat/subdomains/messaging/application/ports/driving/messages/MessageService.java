package de.superchat.subdomains.messaging.application.ports.driving.messages;

import de.superchat.subdomains.messaging.application.model.messages.GetMessageDto;
import de.superchat.subdomains.messaging.application.model.messages.PostMessageDto;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface MessageService {

    Uni<Long> sendMessage(PostMessageDto dto);

    Uni<List<GetMessageDto>> listAllConversations();
}
