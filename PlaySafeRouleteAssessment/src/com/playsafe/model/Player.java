package com.playsafe.model;

public class Player {
	private String name  ;
	private int bet ;
	private String outcone;
	private int winnings;
		
	public Player(String name, int bet, String outcone, int winnings) {
		super();
		this.name = name;
		this.bet = bet;
		this.outcone = outcone;
		this.winnings = winnings;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBet() {
		return bet;
	}
	public void setBet(int bet) {
		this.bet = bet;
	}
	public String getOutcone() {
		return outcone;
	}
	public void setOutcone(String outcone) {
		this.outcone = outcone;
	}
	public int getWinnings() {
		return winnings;
	}
	public void setWinnings(int winnings) {
		this.winnings = winnings;
	}

}
