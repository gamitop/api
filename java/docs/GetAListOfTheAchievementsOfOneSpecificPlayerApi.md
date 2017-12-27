# GetAListOfTheAchievementsOfOneSpecificPlayerApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**seeAchivementsFromSpecificPlayer**](GetAListOfTheAchievementsOfOneSpecificPlayerApi.md#seeAchivementsFromSpecificPlayer) | **GET** /entity/{id_entity}/achievements/players/{id_player} | Get a list of the achievements of one specific player


<a name="seeAchivementsFromSpecificPlayer"></a>
# **seeAchivementsFromSpecificPlayer**
> List&lt;Players&gt; seeAchivementsFromSpecificPlayer(idEntity, idPlayer)

Get a list of the achievements of one specific player

Get a list of the achievements of one specific player 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GetAListOfTheAchievementsOfOneSpecificPlayerApi;


GetAListOfTheAchievementsOfOneSpecificPlayerApi apiInstance = new GetAListOfTheAchievementsOfOneSpecificPlayerApi();
Integer idEntity = 56; // Integer | Id of entity
Integer idPlayer = 56; // Integer | Id of leaderboard
try {
    List<Players> result = apiInstance.seeAchivementsFromSpecificPlayer(idEntity, idPlayer);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GetAListOfTheAchievementsOfOneSpecificPlayerApi#seeAchivementsFromSpecificPlayer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idEntity** | **Integer**| Id of entity |
 **idPlayer** | **Integer**| Id of leaderboard |

### Return type

[**List&lt;Players&gt;**](Players.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/xml

