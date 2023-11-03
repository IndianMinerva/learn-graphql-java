package com.learn.graphql.resolver;

import com.learn.graphql.domain.bank.BankAccount;
import com.learn.graphql.domain.bank.Client;
import com.learn.graphql.domain.bank.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {
    public BankAccount bankAccount(UUID id) {
        log.info("Account id: {}", id);
        Client client1 = Client.builder().id(UUID.randomUUID()).firstName("Neo").lastName("The One").build();
        Client client2 = Client.builder().id(UUID.randomUUID()).firstName("Trinity").lastName("The None").build();

        client1.setClient(client2);
        client2.setClient(client1);


        return BankAccount.builder()
                .id(id)
                .client(client1)
                .currency(Currency.CHF)
                .build();
    }
}
