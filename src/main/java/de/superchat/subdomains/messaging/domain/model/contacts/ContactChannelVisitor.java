package de.superchat.subdomains.messaging.domain.model.contacts;

import de.superchat.subdomains.messaging.domain.model.channels.instagram.InstagramChannel;
import de.superchat.subdomains.messaging.domain.model.channels.sms.SmsChannel;
import de.superchat.subdomains.messaging.domain.model.core.ChannelVisitor;

class ContactChannelVisitor implements ChannelVisitor {

    private final AbstractContact contact;
    private Boolean result;

    ContactChannelVisitor(AbstractContact contact) {
        this.contact = contact;
    }

    @Override
    public void visit(InstagramChannel instagramChannel) {
        result = contact.instagramAccount().isPresent();
    }

    @Override
    public void visit(SmsChannel smsChannel) {
        result = contact.smsNumber().isPresent();
    }

    public Boolean getResult() {
        return result;
    }
}
