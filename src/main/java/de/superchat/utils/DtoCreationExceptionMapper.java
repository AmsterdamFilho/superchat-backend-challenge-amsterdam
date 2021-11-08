package de.superchat.utils;

import com.fasterxml.jackson.databind.exc.ValueInstantiationException;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@ApplicationScoped
public class DtoCreationExceptionMapper implements ExceptionMapper<ValueInstantiationException> {

    @Override
    public Response toResponse(ValueInstantiationException exception) {
        return Response.
                status(Response.Status.BAD_REQUEST).
                entity(ApiException.builder().
                        message(exception.getCause().getMessage()).
                        build()
                ).
                build();
    }
}
