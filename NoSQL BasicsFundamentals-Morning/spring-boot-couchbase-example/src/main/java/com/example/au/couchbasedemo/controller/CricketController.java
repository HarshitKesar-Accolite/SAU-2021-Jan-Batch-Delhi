package com.example.au.couchbasedemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.SQLDeleteAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.CricketPlayer;
import com.example.au.couchbasedemo.repository.CricketRepository;

@RestController
public class CricketController {
	@Autowired
    CricketRepository cricketRepository;
	
	//ADD PLAYER
	@PostMapping("/cricket/player")
    public CricketPlayer addCricketPlayer(@RequestBody CricketPlayer newPlayer) {
        return cricketRepository.save(newPlayer);
    }
	
	//GET ALL THE PLAYERS
	@GetMapping("/cricket/player")
	public List<CricketPlayer> getAllCricketPlayers(){
		return (List<CricketPlayer>) cricketRepository.findAll();
	}
	
	//FIND CRICKET PLAYER BY ID
	@GetMapping("/cricket/player/{id}")
	public Optional<CricketPlayer> getCricketPlayerById(@PathVariable String id) {
		return cricketRepository.findById(id);
	}
	
	//FIND CRICKET PLAYER BY NAME
	@GetMapping("/cricket/player/name/{name}")
	public Optional<CricketPlayer> getCricketPlayerByName(@PathVariable String name) {
		return cricketRepository.findByName(name);
	}
	
	//FIND THE AVERAGE OF THE PLAYER BY ID
	@GetMapping("/cricket/player/average/{id}")
	public double getAverageById(@PathVariable String id) {
		Optional<CricketPlayer> obj =  cricketRepository.findById(id);
		if(obj.isPresent()) {
			return obj.get().getAverage();
		}
		else {
			return -1;
		}
	}
	
	//FIND THE RUNS OF THE PLAYER BY ID
	@GetMapping("/cricket/player/runs/{id}")
	public double getRuns(@PathVariable String id) {
		Optional<CricketPlayer> obj =  cricketRepository.findById(id);
		if(obj.isPresent()) {
			return obj.get().getRuns();
		}
		else {
			return -1;
		}
	}
	
	//FIND NUMBER OF WICKETS OF THE PLAYER BY ID
	@GetMapping("/cricket/player/wickets/{id}")
	public int getWickets(@PathVariable String id) {
		Optional<CricketPlayer> obj =  cricketRepository.findById(id);
		if(obj.isPresent()) {
			return obj.get().getWickets();
		}
		else {
			return -1;
		}
	}
	
	//DELETE PLAYER BY ID
	@DeleteMapping("/cricket/player/{id}")
	public void deletePlayer(@PathVariable String id) {
		cricketRepository.deleteById(id);
	}
	
	//CLEAR ALL THE DATABASE
	@DeleteMapping("/cricket/player")
	public void deleteAllCricketDB() {
		cricketRepository.deleteAll();
	}
	
	//FIND ALL THE CRICKET PLAYERS WHERE RUNS GREATER THAN A GIVEN VALUE
	@GetMapping("/cricket/player/runsGreaterThanValue/{runs}")
	public List<CricketPlayer> getPlayersWhereRunsGreaterThanValue(@PathVariable int runs){
		List<CricketPlayer> result = new ArrayList<>();
		for(CricketPlayer player : cricketRepository.findAll()) {
			if(player.getRuns() > runs) {
				result.add(player);
			}
		}
		return result;
	}
	
}
