package de.superchat.subdomains.messaging.domain.ports.repositories.messages;

import de.superchat.subdomains.messaging.application.model.messages.GetMessageDto;
import de.superchat.subdomains.messaging.domain.model.messages.Message;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface MessageRepository {

    Uni<Long> persist(Message message);

    Uni<List<GetMessageDto>> listAllConversations();
}
