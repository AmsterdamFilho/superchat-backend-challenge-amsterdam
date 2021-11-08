package de.superchat.subdomains.messaging.domain.model.core;

import de.superchat.subdomains.messaging.domain.model.messages.Message;
import io.smallrye.mutiny.Uni;

public abstract class Channel<T> {

    public abstract ChannelName name();

    public abstract T translate(Message message);

    public abstract ChannelPort<T> port();

    public abstract void accept(ChannelVisitor visitor);

    public Uni<Void> send(Message message) {
        return port().sendMessage(translate(message));
    }
}
