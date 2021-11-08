package de.superchat.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@ApplicationScoped
public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(IllegalArgumentException exception) {
        return Response.
                status(Response.Status.BAD_REQUEST).
                entity(ApiException.builder().
                        message(exception.getMessage()).
                        build()
                ).
                build();
    }
}
