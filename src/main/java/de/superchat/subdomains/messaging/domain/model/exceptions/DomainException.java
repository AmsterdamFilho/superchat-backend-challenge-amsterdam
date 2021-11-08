package de.superchat.subdomains.messaging.domain.model.exceptions;

public class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }
}
