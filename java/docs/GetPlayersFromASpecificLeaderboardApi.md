# GetPlayersFromASpecificLeaderboardApi

All URIs are relative to *https://virtserver.swaggerhub.com/gamitop/api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**seePlayersFromSpecificLeaderboard**](GetPlayersFromASpecificLeaderboardApi.md#seePlayersFromSpecificLeaderboard) | **GET** /entity/{id_entity}/leaderboards/{id_leaderboard}/players | Get players from a specific leaderboard


<a name="seePlayersFromSpecificLeaderboard"></a>
# **seePlayersFromSpecificLeaderboard**
> List&lt;Leaderboard&gt; seePlayersFromSpecificLeaderboard(idEntity, idLeaderboard)

Get players from a specific leaderboard

Get players from a specific leaderboard 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GetPlayersFromASpecificLeaderboardApi;


GetPlayersFromASpecificLeaderboardApi apiInstance = new GetPlayersFromASpecificLeaderboardApi();
Integer idEntity = 56; // Integer | Id of entity
Integer idLeaderboard = 56; // Integer | Id of leaderboard
try {
    List<Leaderboard> result = apiInstance.seePlayersFromSpecificLeaderboard(idEntity, idLeaderboard);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GetPlayersFromASpecificLeaderboardApi#seePlayersFromSpecificLeaderboard");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idEntity** | **Integer**| Id of entity |
 **idLeaderboard** | **Integer**| Id of leaderboard |

### Return type

[**List&lt;Leaderboard&gt;**](Leaderboard.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/xml

