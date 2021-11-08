package de.superchat.utils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@DefaultStyle
@Value.Immutable
@JsonSerialize(as = ApiException.class)
@JsonDeserialize(as = ApiException.class)
public abstract class AbstractApiException {

    abstract String message();
}
