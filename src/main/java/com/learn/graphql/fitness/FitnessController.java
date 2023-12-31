package com.learn.graphql.fitness;

import com.learn.graphql.fitness.model.Coach;
import com.learn.graphql.fitness.model.Difficulty;
import com.learn.graphql.fitness.model.FitnessClass;
import graphql.GraphQLContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Function;

import static java.util.stream.Collectors.toUnmodifiableMap;

@Controller
@Slf4j
public class FitnessController {

    @QueryMapping
    public List<FitnessClass> schedule(@Argument Coach coach, GraphQLContext context) {
        var startsAt = LocalDateTime.now();
        log.info("schedule({})", coach);
        context.put("key", "value");

        return List.of(
                FitnessClass
                        .builder()
                        .id(UUID.randomUUID())
                        .coach(coach)
                        .startsAt(startsAt)
                        .endsAt(startsAt.plusHours(1L))
                        .build()
        );
    }


    @BatchMapping
    public Callable<Map<FitnessClass, Difficulty>> difficulty(List<FitnessClass> fitnessClasses, GraphQLContext context) {
        return () -> fitnessClasses.stream()
                .collect(toUnmodifiableMap(Function.identity(), ignore -> Difficulty.BEGINNER));
    }
}
