/**
 * 
 */
/**
 * @author Paulo
 *
 */
package com.gamitop.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entity")

public class Entity {
	
	private int id ;
	 
	private String name ;

	private String email;
	 
	private String username;

	private String password;
	
	private String link;
	
	private  ArrayList<String> leaderboards = new ArrayList<String>();
	private  ArrayList<String> achievements = new ArrayList<String>();
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param username
	 * @param password
	 * @param link
	 * @param leaderboards2
	 */
	
	
	
	public Entity(int id, String name, String email, String username, String password, String link,
			ArrayList<String> leaderboards2,ArrayList<String> achievements2) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.link = link;
		this.leaderboards = leaderboards2;
		this.achievements = achievements2;
	}
	/**
	 * 
	 */
	public Entity() {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public ArrayList<String> getLeaderboards() {
		return leaderboards;
	}
	public void setLeaderboards(ArrayList<String> leaderboards) {
		this.leaderboards = leaderboards;
	}
	
	public ArrayList<String> getAchievements() {
		return achievements;
	}
	public void setAchievements(ArrayList<String> achievements) {
		this.achievements = achievements;
	}
	
	
	
	
	
	
	
	
	
}