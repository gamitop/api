# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.AddAchivementToASpecificEntityApi;

import java.io.File;
import java.util.*;

public class AddAchivementToASpecificEntityApiExample {

    public static void main(String[] args) {
        
        AddAchivementToASpecificEntityApi apiInstance = new AddAchivementToASpecificEntityApi();
        Entity newAchivement = new Entity(); // Entity | Add new Achivement
        try {
            apiInstance.addAchivement(newAchivement);
        } catch (ApiException e) {
            System.err.println("Exception when calling AddAchivementToASpecificEntityApi#addAchivement");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AddAchivementToASpecificEntityApi* | [**addAchivement**](docs/AddAchivementToASpecificEntityApi.md#addAchivement) | **POST** /entity/{id_entity}/achievements | add achivement to a specific entity
*AddAchivementToASpecificPlayerApi* | [**addAchivementToPlayer**](docs/AddAchivementToASpecificPlayerApi.md#addAchivementToPlayer) | **POST** /entity/{id_entity}/achievements/players/{id_player} | add achivemente to a specific player
*AddEntityApi* | [**addEntity**](docs/AddEntityApi.md#addEntity) | **POST** /entity | add entities
*AddLeaderboardApi* | [**addLeaderboard**](docs/AddLeaderboardApi.md#addLeaderboard) | **POST** /entity/{id_entity}/leaderboards | add leaderboard
*AddPlayerApi* | [**addPlayer**](docs/AddPlayerApi.md#addPlayer) | **POST** /entity/{id_entity}/leaderboards/{id_leaderboard}/players | add player
*DeleteASpecificAchivementFromASpecificEntityApi* | [**deleteAchivement**](docs/DeleteASpecificAchivementFromASpecificEntityApi.md#deleteAchivement) | **DELETE** /entity/{id_entity}/achievements/{name} | delete achivement
*DeleteASpecificEntityApi* | [**deleteEntity**](docs/DeleteASpecificEntityApi.md#deleteEntity) | **DELETE** /entity/{id_entity} | delete entity
*DeleteASpecificLeaderboardFromASpecificEntityApi* | [**deleteLeaderboard**](docs/DeleteASpecificLeaderboardFromASpecificEntityApi.md#deleteLeaderboard) | **DELETE** /entity/{id_entity}/leaderboards/{id_leaderboard} | delete leaderboard
*DeleteASpecificPlayerFromASpecificLeaderboardApi* | [**deletePlayer**](docs/DeleteASpecificPlayerFromASpecificLeaderboardApi.md#deletePlayer) | **DELETE** /entity/{id_entity}/leaderboards/{id_leaderboard}/players/{id_player} | delete player
*GetAListOfAchievementsOfOneEntityApi* | [**seeAchivementsFromSpecificEntity**](docs/GetAListOfAchievementsOfOneEntityApi.md#seeAchivementsFromSpecificEntity) | **GET** /entity/{id_entity}/achievements | Get a list of achievements of one entity
*GetAListOfTheAchievementsOfOneSpecificPlayerApi* | [**seeAchivementsFromSpecificPlayer**](docs/GetAListOfTheAchievementsOfOneSpecificPlayerApi.md#seeAchivementsFromSpecificPlayer) | **GET** /entity/{id_entity}/achievements/players/{id_player} | Get a list of the achievements of one specific player
*GetEntitiesApi* | [**seeEntities**](docs/GetEntitiesApi.md#seeEntities) | **GET** /entity | Get a list of all entities
*GetInfoFormASpecificAchivementFromASpecificEntityApi* | [**searchSpecificAchivement**](docs/GetInfoFormASpecificAchivementFromASpecificEntityApi.md#searchSpecificAchivement) | **GET** /entity/{id_entity}/achievements/{name} | 
*GetInfoFormASpecificAchivementFromASpecificEntityApi* | [**searchSpecificAchivement22**](docs/GetInfoFormASpecificAchivementFromASpecificEntityApi.md#searchSpecificAchivement22) | **GET** /entity/{id_entity}/achievements/{achievements}/players/{id_player} | 
*GetInfoFormASpecificEntityApi* | [**searchSpecificEntitie**](docs/GetInfoFormASpecificEntityApi.md#searchSpecificEntitie) | **GET** /entity/{id_entity} | Get a info of one entity
*GetInfoFormASpecificLeaderboardFromASpecificEntityApi* | [**searchSpecificLeaderboard**](docs/GetInfoFormASpecificLeaderboardFromASpecificEntityApi.md#searchSpecificLeaderboard) | **GET** /entity/{id_entity}/leaderboards/{id_leaderboard} | Get info form a specific leaderboard from a specific entity
*GetInfoFormASpecificPlayerFromASpecificLeaderboardApi* | [**searchSpecificPlayer**](docs/GetInfoFormASpecificPlayerFromASpecificLeaderboardApi.md#searchSpecificPlayer) | **GET** /entity/{id_entity}/leaderboards/{id_leaderboard}/players/{id_player} | 
*GetLeaderboardFromASpecificEntityApi* | [**seeLeaderboardsFromSepcifficEntity**](docs/GetLeaderboardFromASpecificEntityApi.md#seeLeaderboardsFromSepcifficEntity) | **GET** /entity/{id_entity}/leaderboards | Get leaderboard from a specific entity
*GetPlayersFromASpecificLeaderboardApi* | [**seePlayersFromSpecificLeaderboard**](docs/GetPlayersFromASpecificLeaderboardApi.md#seePlayersFromSpecificLeaderboard) | **GET** /entity/{id_entity}/leaderboards/{id_leaderboard}/players | Get players from a specific leaderboard
*UpdateASpecificEntityApi* | [**updateEntity**](docs/UpdateASpecificEntityApi.md#updateEntity) | **PUT** /entity/{id_entity} | update entity
*UpdateASpecificLeaderboardFromASpecificEntityApi* | [**updateLeaderboard**](docs/UpdateASpecificLeaderboardFromASpecificEntityApi.md#updateLeaderboard) | **PUT** /entity/{id_entity}/leaderboards/{id_leaderboard} | update leaderboard
*UpdateASpecificPlayerFromASpecificLeaderboardApi* | [**updatePayer**](docs/UpdateASpecificPlayerFromASpecificLeaderboardApi.md#updatePayer) | **PUT** /entity/{id_entity}/leaderboards/{id_leaderboard}/players/{id_player} | update player
*UpdateaSpecificAchivementFromASpecificEntityApi* | [**updateAchivement**](docs/UpdateaSpecificAchivementFromASpecificEntityApi.md#updateAchivement) | **PUT** /entity/{id_entity}/achievements/{name} | update achivement


## Documentation for Models

 - [Achivements](docs/Achivements.md)
 - [Entity](docs/Entity.md)
 - [Leaderboard](docs/Leaderboard.md)
 - [Players](docs/Players.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

you@your-company.com

