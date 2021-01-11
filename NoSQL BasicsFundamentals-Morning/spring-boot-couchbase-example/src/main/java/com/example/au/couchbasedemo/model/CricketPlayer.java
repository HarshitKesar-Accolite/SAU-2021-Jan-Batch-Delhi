package com.example.au.couchbasedemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import com.sun.istack.NotNull;

@Document
public class CricketPlayer {

	@Id
	private String id;
	
	@NotNull
    @Field
	private String name;
	
	@NotNull
    @Field
	private double average;
	
	@NotNull
    @Field
	private double runs;
	
	@NotNull
    @Field
	private int wickets;
	
	public CricketPlayer(String id, String name, double average, double runs, int wickets) {
		this.id = id;
		this.name = name;
		this.average = average;
		this.runs = runs;
		this.wickets = wickets;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String playerName) {
		this.name = playerName;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public double getRuns() {
		return runs;
	}

	public void setRuns(double runs) {
		this.runs = runs;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	
}
