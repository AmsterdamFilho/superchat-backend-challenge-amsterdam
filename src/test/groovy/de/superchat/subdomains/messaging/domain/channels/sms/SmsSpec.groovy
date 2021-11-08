package de.superchat.subdomains.messaging.domain.channels.sms

import de.superchat.subdomains.messaging.domain.model.channels.sms.Sms
import spock.lang.Specification

class SmsSpec extends Specification {

    def "sms text should have at most 20 characters"() {
        given:
        var text = "This message has too many characters for a sms"

        when:
        Sms.builder().
                contactSmsNumber("+55 62 71288 9991").
                text(text).
                build()

        then:
        thrown IllegalArgumentException
    }
}
