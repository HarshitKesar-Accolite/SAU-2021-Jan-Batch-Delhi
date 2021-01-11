package com.example.au.couchbasedemo.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.example.au.couchbasedemo.model.CricketPlayer;

public interface CricketRepository extends CrudRepository<CricketPlayer, String>{

	Optional<CricketPlayer> findByName(String name);
	
}
