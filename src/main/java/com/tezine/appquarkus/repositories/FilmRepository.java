package com.tezine.appquarkus.repositories;

import com.tezine.appquarkus.entities.Film;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FilmRepository implements PanacheRepository<Film> {
    
}
