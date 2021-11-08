package de.superchat.utils;

import de.superchat.subdomains.messaging.domain.model.exceptions.DomainException;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@ApplicationScoped
public class DomainExceptionMapper implements ExceptionMapper<DomainException> {

    @Override
    public Response toResponse(DomainException exception) {
        return Response.
                status(Response.Status.BAD_REQUEST).
                entity(ApiException.builder().
                        message(exception.getMessage()).
                        build()
                ).
                build();
    }
}
