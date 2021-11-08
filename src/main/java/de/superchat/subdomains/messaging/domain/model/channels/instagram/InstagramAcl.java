package de.superchat.subdomains.messaging.domain.model.channels.instagram;

import de.superchat.subdomains.messaging.application.services.channels.ChannelService;
import de.superchat.subdomains.messaging.domain.model.core.ChannelName;
import de.superchat.subdomains.messaging.domain.model.messages.Message;
import de.superchat.subdomains.messaging.domain.model.messages.MessageType;
import de.superchat.subdomains.messaging.domain.ports.repositories.contacts.ContactRepository;
import de.superchat.subdomains.messaging.domain.ports.repositories.messages.MessageRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class InstagramAcl {

    @Inject ChannelService channelService;
    @Inject ContactRepository contactRepository;
    @Inject MessageRepository messageRepository;

    public InstagramMessage translate(Message message) {
        return InstagramMessage.builder().
                contactInstagramAccount(message.contact().instagramAccount().orElseThrow()).
                content(message.content()).
                build();
    }

    public Uni<Message> receiveMessage(InstagramMessage instagramMessage) {
        return contactRepository.findByInstagramAccount(instagramMessage.contactInstagramAccount()).
                map(contact -> Message.builder().
                        channel(channelService.getChannel(ChannelName.INSTAGRAM)).
                        content(instagramMessage.content()).
                        contact(contact).
                        type(MessageType.INCOMING).
                        build()
                ).
                flatMap(message -> message.persist(messageRepository));
    }
}
