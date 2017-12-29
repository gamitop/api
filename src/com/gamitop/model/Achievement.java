package com.gamitop.model;

public class Achievement {

	private int id ;
	private String name ;
	private int entity ;
	private String description ;
	private String link ;
	/**
	 * @param id
	 * @param name
	 * @param entity
	 * @param description
	 * @param link
	 */
	public Achievement(int id, String name, int entity, String description, String link) {
		super();
		this.id = id;
		this.name = name;
		this.entity = entity;
		this.description = description;
		this.link = link;
	}
	/**
	 * 
	 */
	public Achievement() {
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
	
	
	
}
