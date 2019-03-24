package com.ragnarok.model;

public class Player {

	private int numberPlayer;
	private String name;
	private int punctuation;
	
	//Default constructor
	public Player(int numberPlayer) {
		this(numberPlayer, "anonymous");
	}

	public Player(int numberPlayer, String name) {
		this.numberPlayer = numberPlayer;
		this.name = name;
		this.punctuation = 0;
	}

	public int getNumberPlayer() {
		return numberPlayer;
	}

	public void setNumberPlayer(int numberPlayer) {
		this.numberPlayer = numberPlayer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPunctuation() {
		return punctuation;
	}

	public void setPunctuation(int punctuation) {
		this.punctuation = punctuation;
	}
	
}
