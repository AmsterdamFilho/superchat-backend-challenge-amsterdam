package de.superchat.subdomains.messaging.domain.ports.external_services.blockchain;

import io.smallrye.mutiny.Uni;

import java.math.BigDecimal;

public interface BlockchainPort {

    Uni<BigDecimal> getBitcoinPrice();
}
