package com.tezine.appquarkus.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.tezine.appquarkus.entities.Film;
import com.tezine.appquarkus.entities.Hero;
import com.tezine.appquarkus.repositories.FilmRepository;
import com.tezine.appquarkus.repositories.HeroRepository;

@ApplicationScoped
public class GalaxyService {


    @Inject
    FilmRepository filmRepository;
    @Inject
    HeroRepository heroRepository;

    public GalaxyService() {
    }

    public List<Film> getAllFilms() {
        var result = filmRepository.listAll();
        return result;
    }

    public Film getFilm(long id) {
        var film = filmRepository.findById(id);
        
        return film;
    }

    public List<Hero> getHeroesByFilm(Film film) {
        var heroList=getAllHeroes();
        var episodeID=String.valueOf(film.getId());
        var resultList=heroList.stream().filter(hero->hero.getEpisodeIds().contains(episodeID)).collect(Collectors.toList());
        return resultList;
    }

    public List<Hero> getAllHeroes() {
        var result = heroRepository.listAll();
        return result;
    }

    public Hero getHeroById(long id) {
        return heroRepository.findById(id);
    }

    @Transactional
    public void addHero(Hero hero) {
        heroRepository.persistAndFlush(hero);
    }

    @Transactional
    public boolean deleteHero(int id) {
        var hero = getHeroById(id);
        if (hero == null)
            return false;
        heroRepository.delete(hero);
        return true;
    }

    public List<Hero> getHeroesBySurname(String surname) {
        return getAllHeroes().stream()
                .filter(hero -> hero.getSurname().equals(surname))
                .collect(Collectors.toList());
    }
}
