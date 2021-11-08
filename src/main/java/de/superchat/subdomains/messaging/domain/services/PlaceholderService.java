package de.superchat.subdomains.messaging.domain.services;

import de.superchat.subdomains.messaging.domain.model.messages.Message;
import de.superchat.subdomains.messaging.domain.ports.external_services.blockchain.BlockchainPort;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.text.NumberFormat;

@ApplicationScoped
public class PlaceholderService {

    @Inject BlockchainPort blockchainPort;

    public Uni<String> execute(Message message) {
        return Uni.createFrom().
                item(message::content).
                map(content -> content.replace("{{contactName}}", message.contact().name())).
                flatMap(content -> {
                    if (content.contains("{{bitcoinPrice}}")) {
                        return blockchainPort.getBitcoinPrice().
                                map(price -> NumberFormat.getCurrencyInstance().format(price)).
                                map(price -> content.replace("{{bitcoinPrice}}", price));
                    } else {
                        return Uni.createFrom().item(content);
                    }
                });
    }
}
