package de.superchat.subdomains.messaging.domain.model.core;

import de.superchat.subdomains.messaging.domain.model.channels.instagram.InstagramChannel;
import de.superchat.subdomains.messaging.domain.model.channels.sms.SmsChannel;

public interface ChannelVisitor {

    void visit(InstagramChannel instagramChannel);

    void visit(SmsChannel smsChannel);
}
