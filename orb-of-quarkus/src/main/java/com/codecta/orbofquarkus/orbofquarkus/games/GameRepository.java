package com.codecta.orbofquarkus.orbofquarkus.games;

import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<GameEntity, Integer>  {
}
