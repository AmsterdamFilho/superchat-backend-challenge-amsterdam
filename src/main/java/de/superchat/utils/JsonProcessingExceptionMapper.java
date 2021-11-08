package de.superchat.utils;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Provider
@ApplicationScoped
public class JsonProcessingExceptionMapper implements ExceptionMapper<JsonProcessingException> {

    @Override
    public Response toResponse(JsonProcessingException exception) {
        return Response.
                status(BAD_REQUEST).
                entity(ApiException.builder().message(exception.getMessage()).build()).
                build();
    }
}
