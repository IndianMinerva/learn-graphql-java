package com.learn.graphql.domain.bank;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class Client {
    UUID id;
    String firstName;
    String[] middleNames;
    String lastName;
}
