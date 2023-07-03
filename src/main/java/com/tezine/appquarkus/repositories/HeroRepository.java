package com.tezine.appquarkus.repositories;

import com.tezine.appquarkus.entities.Hero;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HeroRepository implements PanacheRepository<Hero>{
    
}
