package de.superchat.subdomains.messaging.adapters.external_services.blockchain;

import de.superchat.subdomains.messaging.domain.ports.external_services.blockchain.BlockchainPort;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@ApplicationScoped
public class BlockchainAdapter implements BlockchainPort {

    @Override
    public Uni<BigDecimal> getBitcoinPrice() {
        return Uni.createFrom().item(new BigDecimal("12333.22"));
    }
}
