package de.superchat.subdomains.messaging.application.services.channels;

import de.superchat.subdomains.messaging.domain.model.core.Channel;
import de.superchat.subdomains.messaging.domain.model.core.ChannelName;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

@ApplicationScoped
public class ChannelService {

    @Inject Instance<Channel<?>> allChannels;

    public Channel<?> getChannel(ChannelName channelName) {
        return allChannels.stream().
                filter(channel -> channel.name().equals(channelName)).
                findFirst().
                orElseThrow();
    }
}
