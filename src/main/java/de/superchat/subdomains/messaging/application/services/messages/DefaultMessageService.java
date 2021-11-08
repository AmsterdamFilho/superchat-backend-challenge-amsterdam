package de.superchat.subdomains.messaging.application.services.messages;

import de.superchat.subdomains.messaging.application.model.messages.GetMessageDto;
import de.superchat.subdomains.messaging.application.model.messages.PostMessageDto;
import de.superchat.subdomains.messaging.application.services.channels.ChannelService;
import de.superchat.subdomains.messaging.domain.model.messages.Message;
import de.superchat.subdomains.messaging.domain.model.messages.MessageType;
import de.superchat.subdomains.messaging.domain.ports.repositories.contacts.ContactRepository;
import de.superchat.subdomains.messaging.application.ports.driving.messages.MessageService;
import de.superchat.subdomains.messaging.domain.ports.repositories.messages.MessageRepository;
import de.superchat.subdomains.messaging.domain.services.PlaceholderService;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class DefaultMessageService implements MessageService {

    @Inject ChannelService channelService;
    @Inject ContactRepository contactRepository;
    @Inject MessageRepository messageRepository;
    @Inject PlaceholderService placeholderService;

    @Override
    public Uni<List<GetMessageDto>> listAllConversations() {
        return messageRepository.listAllConversations();
    }

    @Override
    public Uni<Long> sendMessage(PostMessageDto dto) {
        return contactRepository.findById(dto.contactId()).
                map(contact -> Message.builder().
                        contact(contact).
                        channel(channelService.getChannel(dto.channel())).
                        content(dto.messageContent()).
                        type(MessageType.OUTGOING).
                        build()
                ).
                flatMap(message -> message.send(messageRepository, placeholderService)).
                map(message -> message.id().orElseThrow());
    }
}
