package de.superchat.subdomains.messaging.domain.model.core;

import io.smallrye.mutiny.Uni;

public interface ChannelPort<T> {

    Uni<Void> sendMessage(T message);
}
