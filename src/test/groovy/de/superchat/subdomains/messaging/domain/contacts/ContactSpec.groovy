package de.superchat.subdomains.messaging.domain.contacts


import de.superchat.subdomains.messaging.domain.model.channels.instagram.InstagramChannel
import de.superchat.subdomains.messaging.domain.model.contacts.Contact
import spock.lang.Specification

class ContactSpec extends Specification {

    def "hasChannel method should return true for a contact that has an instagram account"() {
        given:
        var channel = new InstagramChannel()
        var contact = Contact.builder().
                instagramAccount("instagramAccount").
                name("name").
                build()

        when:
        var result = contact.hasChannel(channel)

        then:
        result
    }
}
