package de.superchat.subdomains.messaging.adapters.db.messages.record;

import de.superchat.subdomains.messaging.adapters.db.contacts.records.ContactRecord;
import de.superchat.subdomains.messaging.domain.model.core.ChannelName;
import de.superchat.subdomains.messaging.domain.model.messages.Message;
import de.superchat.subdomains.messaging.domain.model.messages.MessageType;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class MessageRecord extends PanacheEntity {

    public ChannelName channel;

    @ManyToOne
    public ContactRecord contact;

    public String content;

    public MessageType type;

    public static MessageRecord fromDomain(Message message) {
        MessageRecord messageRecord = new MessageRecord();
        message.id().ifPresent(id -> messageRecord.id = id);
        messageRecord.channel = message.channel().name();
        messageRecord.contact = ContactRecord.fromDomain(message.contact());
        messageRecord.content = message.content();
        messageRecord.type = message.type();
        return messageRecord;
    }
}
