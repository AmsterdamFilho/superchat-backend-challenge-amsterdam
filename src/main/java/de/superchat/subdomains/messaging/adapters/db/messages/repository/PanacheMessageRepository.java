package de.superchat.subdomains.messaging.adapters.db.messages.repository;

import de.superchat.subdomains.messaging.adapters.db.messages.record.MessageRecord;
import de.superchat.subdomains.messaging.application.model.messages.GetMessageDto;
import de.superchat.subdomains.messaging.domain.model.messages.Message;
import de.superchat.subdomains.messaging.domain.ports.repositories.messages.MessageRepository;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PanacheMessageRepository implements MessageRepository {

    @Override
    public Uni<List<GetMessageDto>> listAllConversations() {
        return MessageRecord.
                <MessageRecord>listAll().
                map(messageRecords -> messageRecords.
                        stream().
                        map(messageRecord -> GetMessageDto.builder().
                                channel(messageRecord.channel).
                                contact(messageRecord.contact.toDomain()).
                                content(messageRecord.content).
                                id(messageRecord.id).
                                type(messageRecord.type).
                                build()).
                        collect(Collectors.toList())
                );
    }

    @Override
    @ReactiveTransactional
    public Uni<Long> persist(Message message) {
        return MessageRecord.fromDomain(message).
                <MessageRecord>persistAndFlush().
                map(messageRecord -> messageRecord.id);
    }
}
