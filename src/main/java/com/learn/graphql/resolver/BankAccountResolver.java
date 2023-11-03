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
        return BankAccount.builder()
                .id(id)
                .client(Client.builder().id(UUID.randomUUID()).firstName("First").lastName("Last").middleNames(null).build())
                .currency(Currency.CHF)
                .build();
    }
}
