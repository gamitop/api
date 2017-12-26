package com.gamitop.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "leaderboard")
public class Leaderboard {

	private int id;
	private String name;
	private int entity;
	private String description;
	private String link;
	private ArrayList<String> players = new ArrayList<String>();

	/**
	 * @param id
	 * @param name
	 * @param entity
	 * @param description
	 * @param link
	 * @param players
	 */
	public Leaderboard(int id, String name, int entity, String description, String link, ArrayList<String> players2) {
		super();
		this.id = id;
		this.name = name;
		this.entity = entity;
		this.description = description;
		this.link = link;
		this.players = players2;
	}

	/**
	 * 
	 */
	public Leaderboard() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEntity() {
		return entity;
	}

	public void setEntity(int entity) {
		this.entity = entity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public ArrayList<String> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<String> players) {
		this.players = players;
	}

}
