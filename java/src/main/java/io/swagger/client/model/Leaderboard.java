package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Leaderboard
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-12-19T10:23:06.463Z")
public class Leaderboard {
  @SerializedName("id2")
  private Integer id2 = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("entity")
  private String entity = null;

  @SerializedName("players")
  private List<String> players = new ArrayList<String>();

  public Leaderboard id2(Integer id2) {
    this.id2 = id2;
    return this;
  }

   /**
   * Get id2
   * @return id2
  **/
  @ApiModelProperty(example = "3211684", required = true, value = "")
  public Integer getId2() {
    return id2;
  }

  public void setId2(Integer id2) {
    this.id2 = id2;
  }

  public Leaderboard name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "LeaderboardName", required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Leaderboard entity(String entity) {
    this.entity = entity;
    return this;
  }

   /**
   * Get entity
   * @return entity
  **/
  @ApiModelProperty(example = "empresaX", required = true, value = "")
  public String getEntity() {
    return entity;
  }

  public void setEntity(String entity) {
    this.entity = entity;
  }

  public Leaderboard players(List<String> players) {
    this.players = players;
    return this;
  }

  public Leaderboard addPlayersItem(String playersItem) {
    this.players.add(playersItem);
    return this;
  }

   /**
   * Get players
   * @return players
  **/
  @ApiModelProperty(example = "[\"Bruno\",\"Miguel\"]", required = true, value = "")
  public List<String> getPlayers() {
    return players;
  }

  public void setPlayers(List<String> players) {
    this.players = players;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Leaderboard leaderboard = (Leaderboard) o;
    return Objects.equals(this.id2, leaderboard.id2) &&
        Objects.equals(this.name, leaderboard.name) &&
        Objects.equals(this.entity, leaderboard.entity) &&
        Objects.equals(this.players, leaderboard.players);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id2, name, entity, players);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Leaderboard {\n");
    
    sb.append("    id2: ").append(toIndentedString(id2)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
    sb.append("    players: ").append(toIndentedString(players)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

