package com.learn.graphql.domain.bank;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.util.UUID;

@Data
@Builder
public class Client {
    UUID id;
    String firstName;
    String[] middleNames;
    String lastName;
    @Setter
    Client client;
}
