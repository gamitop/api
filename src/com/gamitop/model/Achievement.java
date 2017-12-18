package com.gamitop.model;

public class Achievement {

	private int id ;
	private String name ;
	private String entity ;
	private String description ;
	private String link ;
	/**
	 * @param id
	 * @param name
	 * @param entity
	 * @param description
	 * @param link
	 */
	public Achievement(int id, String name, String entity, String description, String link) {
		super();
		this.id = id;
		this.name = name;
		this.entity = entity;
		this.description = description;
		this.link = link;
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
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
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
	
	
	
	
	/*
 * 
 * 
 * 
 *   "id": "",
        "name": "",
        // ID entidade
        "entidade": "",
        // ID "players"  
        "players": [{
            "player": {
                "name": "",
                "achievements": {
                    "achievement": [
                        "",
                        ""
                    ]
                },
                //Este score pode ser adaptamos a diferentes situações( p.e: Tempo de realização)
                "score": ""
            }
        }],
        "link": ""
 */
}
