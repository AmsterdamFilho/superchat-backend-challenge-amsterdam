package de.superchat.subdomains.messaging.domain.model.channels.sms;

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
public class SmsAcl {

    @Inject ChannelService channelService;
    @Inject ContactRepository contactRepository;
    @Inject MessageRepository messageRepository;

    public Sms translate(Message message) {
        return Sms.builder().
                contactSmsNumber(message.contact().smsNumber().orElseThrow()).
                text(message.content()).
                build();
    }

    public Uni<Message> receiveMessage(Sms sms) {
        return contactRepository.findBySmsNumber(sms.contactSmsNumber()).
                map(contact -> Message.builder().
                        channel(channelService.getChannel(ChannelName.SMS)).
                        content(sms.text()).
                        contact(contact).
                        type(MessageType.INCOMING).
                        build()
                ).
                flatMap(message -> message.persist(messageRepository));
    }
}
