package com.devgps.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devgps.mvc.model.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

}