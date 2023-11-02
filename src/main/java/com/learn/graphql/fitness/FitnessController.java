package com.learn.graphql.fitness;

import com.learn.graphql.fitness.model.Coach;
import com.learn.graphql.fitness.model.Difficulty;
import com.learn.graphql.fitness.model.Fitness;
import graphql.GraphQLContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
public class FitnessController {

    @QueryMapping
    public List<Fitness> schedule(@Argument Coach coach, GraphQLContext context) {
        var startsAt = LocalDateTime.now();
        log.info("schedule({})", coach);
        context.put("key", "value");

        return List.of(
                Fitness
                        .builder()
                        .id(UUID.randomUUID())
                        .coach(coach)
                        .startsAt(startsAt)
                        .endsAt(startsAt.plusHours(1L))
                        .difficulty(Difficulty.BEGINNER)
                        .build()
        );
    }
}
